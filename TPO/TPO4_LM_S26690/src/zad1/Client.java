package zad1;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

public class Client extends JFrame
{
    JTextArea article;
    JTextArea serverMessage;
    JComboBox<String> topics;

    SocketChannel serverChannel;
    private static final int serverPort = 8080;
    private final String host = Utility.getHost();
    private String topic;

    public Client()
    {
        setTitle("Client Project 4");
        setSize(440, 350);

        try
        {
            serverChannel = SocketChannel.open(new InetSocketAddress(host, serverPort));
            serverChannel.configureBlocking(true);
            listenForMessage();
        }
        catch (IOException e)
        {
            System.out.println("[CLIENT ERROR]: can't connect to server");
        }

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        JPanel subscribePanel = new JPanel();
        subscribePanel.setLayout(new FlowLayout());
        JLabel infoSubscribe = new JLabel("Topics: ");
        subscribePanel.add(infoSubscribe);
        topics = new JComboBox<>();
        topics.setPreferredSize(new Dimension(200, topics.getPreferredSize().height));
        topics.addActionListener(e -> topic = (String) topics.getSelectedItem());
        subscribePanel.add(topics);
        JButton refreshButton = new JButton("Refresh");
        subscribePanel.add(refreshButton);
        JButton subscribe = new JButton("Subscribe");
        subscribePanel.add(subscribe);
        JButton unsubscribe = new JButton("Remove");
        subscribePanel.add(unsubscribe);
        serverMessage = new JTextArea();
        serverMessage.setPreferredSize(new Dimension(300, serverMessage.getPreferredSize().height));
        subscribePanel.add(serverMessage);
        subscribe.addActionListener(e -> {
            if (topic != null)
                sendObjectToServer(topic, "subscribe");
        });
        unsubscribe.addActionListener(e -> {
            if (topic != null)
                sendObjectToServer(topic, "unsubscribe");
        });
        refreshButton.addActionListener(e -> sendObjectToServer(topic, "topics"));
        panel.add(subscribePanel);

        JPanel articlePanel = new JPanel();
        articlePanel.setLayout(new FlowLayout());
        JLabel articleLabel = new JLabel("Articles: ");
        articlePanel.add(articleLabel);
        articlePanel.setLayout(new FlowLayout());
        article = new JTextArea(7, 35);
        article.setEditable(false);
        articlePanel.add(article);
        panel.add(articlePanel);

        add(panel);
        setVisible(true);
    }

    public void handleMessage(String message)
    {
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(message, JsonObject.class);
        if (Utility.getMode(jsonObject).equals("subscribe"))
            serverMessage.setText(Utility.getMessage(jsonObject));
        else if (Utility.getMode(jsonObject).equals("unsubscribe"))
            serverMessage.setText(Utility.getMessage(jsonObject));
        else if (Utility.getMode(jsonObject).equals("topics"))
        {
            topics.removeAllItems();
            for (String topic : Utility.getTopics(jsonObject))
                topics.addItem(topic);
        }
        else if (Utility.getMode(jsonObject).equals("article"))
            article.append(Utility.getTopic(jsonObject) + ":\n" + Utility.getArticle(jsonObject) + "\n");
        else if (Utility.getMode(jsonObject).equals("update"))
            serverMessage.setText(Utility.getMessage(jsonObject));
    }

    public void listenForMessage()
    {
        new Thread(() -> {
            try
            {
                while (true)
                {
                    ByteBuffer buffer = ByteBuffer.allocate(2048);
                    int bytesRead = serverChannel.read(buffer);
                    if (bytesRead > 0)
                    {
                        buffer.flip();
                        String message = StandardCharsets.UTF_8.decode(buffer).toString();
                        handleMessage(message);
                    }
                }
            }
            catch (IOException e)
            {
                System.out.println("[CLIENT] Error: while receiving data from server");
            }
        }).start();
    }

    public void sendObjectToServer(String category, String mode)
    {
        JsonObject jsonObject = Utility.createJson("client", mode, category, "", "");
        Gson gson = new Gson();
        String jsonStr = gson.toJson(jsonObject);
        try
        {
            if (serverChannel.isConnected())
            {
                ByteBuffer buffer = ByteBuffer.wrap(jsonStr.getBytes());
                serverChannel.write(buffer);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Client();
    }
}
