package zad1;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.*;

public class Server
{
    private static final int localPort = 8080;
    private static final String host = Utility.getHost();
    private static Map<SocketChannel, Set<String>> clients;
    private static Set<String> topics;

    public Server()
    {
        clients = new HashMap<>();
        topics = new HashSet<>();
        try
        {
            Selector selector = Selector.open();
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            assert host != null;
            serverSocketChannel.bind(new InetSocketAddress(host, localPort));
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            Gson gson = new Gson();

            while (true)
            {
                selector.select();
                Iterator<SelectionKey> keyIterator = selector.selectedKeys().iterator();
                while (keyIterator.hasNext())
                {
                    SelectionKey key = keyIterator.next();
                    keyIterator.remove();
                    if (key.isAcceptable())
                    {
                        SocketChannel socketChannel = serverSocketChannel.accept();
                        socketChannel.configureBlocking(false);
                        socketChannel.register(selector, SelectionKey.OP_READ);
                        clients.put(socketChannel, new HashSet<>());
                        continue;
                    }
                    if (key.isReadable())
                    {
                        SocketChannel socketChannel = (SocketChannel) key.channel();
                        ByteBuffer buffer = ByteBuffer.allocate(2048);
                        socketChannel.read(buffer);
                        buffer.flip();

                        String jsonString = new String(buffer.array(), 0, buffer.limit());
                        JsonObject jsonObject = gson.fromJson(jsonString, JsonObject.class);
                        if (Utility.isAdmin(jsonObject))
                            clients.remove(socketChannel);
                        handleRequest(jsonObject, socketChannel);
                    }
                }
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private void sendNewArticle(JsonObject jsonObject, SocketChannel socketChannel) throws IOException
    {
        if (!topics.contains(Utility.getTopic(jsonObject)))
        {
            String response = "[SERVER]: cant write article for non-existing topic";
            JsonObject json = Utility.createJson("", "", "", "", response);
            Utility.sendJson(socketChannel, json);
            return;
        }
        String response = "[SERVER]: posted an article";
        JsonObject json = Utility.createJson("", "", "", "", response);
        Utility.sendJson(socketChannel, json);

        for (Map.Entry<SocketChannel, Set<String>> entry : clients.entrySet())
        {
            SocketChannel clientChannel = entry.getKey();
            Set<String> topics = entry.getValue();
            if (topics.contains(Utility.getTopic(jsonObject)))
            {
                Utility.sendJson(clientChannel, jsonObject);
            }
        }
    }

    private void notifyClients(String message) throws IOException {
        String serverMessage = "[SERVER]: " + message;
        for (SocketChannel socketChannel : clients.keySet())
        {
            JsonObject json = Utility.createJson("", "update", "", "", serverMessage);
            Utility.sendJson(socketChannel, json);
        }
    }

    private void removeExistingTopic(JsonObject jsonObject, SocketChannel socketChannel) throws IOException
    {
        String response;
        if (topics.contains(Utility.getTopic(jsonObject)))
        {
            clients.entrySet().removeIf(e -> e.getValue().removeIf(t -> t.equals(Utility.getTopic(jsonObject))));
            topics.remove(Utility.getTopic(jsonObject));
            response = "[SERVER]: topic has been removed: " + Utility.getTopic(jsonObject);
            notifyClients("admin removed topic: " + Utility.getTopic(jsonObject));
        }
        else
            response = "[SERVER]: that topic does not exist";
        JsonObject json = Utility.createJson("", "", "", "", response);
        Utility.sendJson(socketChannel, json);
    }

    private void createNewTopic(JsonObject jsonObject, SocketChannel socketChannel) throws IOException
    {
        String response;
        if (topics.contains(Utility.getTopic(jsonObject)))
        {
            response = "[SERVER]: that topic already exists";
            JsonObject json = Utility.createJson("", "", "", "", response);
            Utility.sendJson(socketChannel, json);
        }
        else
        {
            topics.add(Utility.getTopic(jsonObject));
            response = "[SERVER]: successfully created topic: " + Utility.getTopic(jsonObject);
            notifyClients("admin added topic: " + Utility.getTopic(jsonObject));
            JsonObject json = Utility.createJson("", "", "", "", response);
            Utility.sendJson(socketChannel, json);
        }
    }

    private void subscribeClient(JsonObject jsonObject, SocketChannel socketChannel) throws IOException
    {
        if (!topics.contains(Utility.getTopic(jsonObject)))
        {
            String response = "[SERVER]: topic does not exist";
            JsonObject json = Utility.createJson("", "subscribe", "", "", response);
            Utility.sendJson(socketChannel, json);
            return;
        }
        clients.get(socketChannel).add(Utility.getTopic(jsonObject));
        String response = "[SERVER]: subscribed to topic: " + Utility.getTopic(jsonObject);
        JsonObject json = Utility.createJson("", "subscribe", "", "", response);
        Utility.sendJson(socketChannel, json);
    }

    private void unSubscribeClient(JsonObject jsonObject, SocketChannel socketChannel) throws IOException
    {
        String response = "[SERVER]: topic does not exist or you are not subscribed to";
        if (clients.containsKey(socketChannel))
        {
            clients.get(socketChannel).remove(Utility.getTopic(jsonObject));
            response = "[SERVER]: unsubscribed to topic: " + Utility.getTopic(jsonObject);
        }
        JsonObject json = Utility.createJson("", "unsubscribe", "", "", response);
        Utility.sendJson(socketChannel, json);
    }

    private void sendTopicList(SocketChannel socketChannel) throws IOException
    {
        JsonObject json = Utility.createJson("", "topics", "", "", topics, "");
        Utility.sendJson(socketChannel, json);
    }

    private void handleRequest(JsonObject jsonObject, SocketChannel socketChannel) throws IOException
    {
        if (Utility.isAdmin(jsonObject))
        {
            if (Utility.getMode(jsonObject).equals("add"))
                createNewTopic(jsonObject, socketChannel);
            else if (Utility.getMode(jsonObject).equals("remove"))
                removeExistingTopic(jsonObject, socketChannel);
            else if (Utility.getMode(jsonObject).equals("article"))
                sendNewArticle(jsonObject, socketChannel);
        }
        else if (Utility.isClient(jsonObject))
        {
            if (Utility.getMode(jsonObject).equals("subscribe"))
                subscribeClient(jsonObject, socketChannel);
            else if (Utility.getMode(jsonObject).equals("unsubscribe"))
                unSubscribeClient(jsonObject, socketChannel);
            else if (Utility.getMode(jsonObject).equals("topics"))
                sendTopicList(socketChannel);
        }
    }
}
