package zad1;

import com.google.gson.*;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Set;

public class Utility
{
    public static String getHost()
    {
        try
        {
            InetAddress localHost = InetAddress.getLocalHost();
            return localHost.getHostAddress();
        }
        catch (UnknownHostException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean isAdmin(JsonObject jsonObject)
    {
        String role = jsonObject.get("role").getAsString();
        return role.equals("admin");
    }

    public static boolean isClient(JsonObject jsonObject)
    {
        String role = jsonObject.get("role").getAsString();
        return role.equals("client");
    }

    public static String getMode(JsonObject jsonObject)
    {
        return jsonObject.get("mode").getAsString();
    }

    public static String getTopic(JsonObject jsonObject)
    {
        return jsonObject.get("topic").getAsString();
    }

    public static String getArticle(JsonObject jsonObject)
    {
        return jsonObject.get("article").getAsString();
    }

    public static ArrayList<String> getTopics(JsonObject jsonObject)
    {
        ArrayList<String> topics = new ArrayList<>();
        JsonArray jsonArray = jsonObject.get("topics").getAsJsonArray();
        for (JsonElement jsonElement : jsonArray)
            topics.add(jsonElement.getAsString());
        return topics;
    }

    public static String getMessage(JsonObject jsonObject)
    {
        return jsonObject.get("message").getAsString();
    }

    public static JsonObject createJson(String role, String mode, String topic, String article, String message)
    {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("role", role);
        jsonObject.addProperty("mode", mode);
        jsonObject.addProperty("topic", topic);
        jsonObject.addProperty("article", article);
        jsonObject.add("topics",new JsonArray());
        jsonObject.addProperty("message", message);
        return jsonObject;
    }

    public static JsonObject createJson(String role, String mode, String topic, String article, Set<String> topics, String message)
    {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("role", role);
        jsonObject.addProperty("mode", mode);
        jsonObject.addProperty("topic", topic);
        jsonObject.addProperty("article", article);
        JsonArray jsonArray = new JsonArray();
        for (String topicName : topics)
            jsonArray.add(topicName);
        jsonObject.add("topics", jsonArray);
        jsonObject.addProperty("message", message);
        return jsonObject;
    }

    public static void sendJson(SocketChannel socketChannel, JsonObject jsonObject) throws IOException
    {
        if (socketChannel.isConnected())
        {
            Gson gson = new Gson();
            String jsonString = gson.toJson(jsonObject);
            ByteBuffer buffer = ByteBuffer.wrap(jsonString.getBytes());
            socketChannel.write(buffer);
        }
    }
}
