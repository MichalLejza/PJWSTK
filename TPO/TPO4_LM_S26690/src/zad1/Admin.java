package zad1;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class Admin extends JFrame
{
    private static final int serverPort = 8080;
    private final String host = Utility.getHost();
    private SocketChannel serverChannel;

    public Admin()
    {
        setTitle("Admin Project 4");
        setSize(440, 350);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));

        JPanel categoryPanel = new JPanel();
        categoryPanel.setLayout(new FlowLayout());
        JLabel infoCategory = new JLabel("Category:");
        categoryPanel.add(infoCategory);
        JTextField writeCategory = new JTextField(10);
        categoryPanel.add(writeCategory);
        JButton addCategory = new JButton("Add");
        categoryPanel.add(addCategory);
        JButton removeCategory = new JButton("Remove");
        categoryPanel.add(removeCategory);
        JTextField serverResponseCategory = new JTextField(30);
        categoryPanel.add(serverResponseCategory);
        addCategory.addActionListener(e -> {
            if (!writeCategory.getText().isEmpty())
            {
                String category = writeCategory.getText();
                String message = sendObjectToServer("add", category, "");
                serverResponseCategory.setText(message);
            }
        });
        removeCategory.addActionListener(e -> {
            if (!writeCategory.getText().isEmpty())
            {
                String category = writeCategory.getText();
                String message = sendObjectToServer("remove", category, "");
                serverResponseCategory.setText(message);
            }
        });
        panel.add(categoryPanel);

        JPanel articlePanel = new JPanel();
        articlePanel.setLayout(new FlowLayout());
        JLabel infoArticle = new JLabel("Add Article:");
        articlePanel.add(infoArticle);
        JTextField articleTopic = new JTextField(15);
        articlePanel.add(articleTopic);
        JTextArea writeArticle = new JTextArea(5,30);
        articlePanel.add(writeArticle);
        JButton addArticle = new JButton("Add");
        articlePanel.add(addArticle);
        JTextField serverResponseArticle = new JTextField(30);
        articlePanel.add(serverResponseArticle);
        addArticle.addActionListener(e -> {
            if (!writeArticle.getText().isEmpty() && !articleTopic.getText().isEmpty())
            {
                String article = writeArticle.getText();
                String topic = articleTopic.getText();
                String message = sendObjectToServer("article", topic, article);
                serverResponseArticle.setText(message);
            }
        });
        panel.add(articlePanel);

        add(panel);
        setVisible(true);
    }

    public String sendObjectToServer(String mode, String topic, String article)
    {
        JsonObject jsonObject = Utility.createJson("admin", mode, topic, article, "");
        Gson gson = new Gson();
        String jsonStr = gson.toJson(jsonObject);
        String message = "ERROR: something went wrong with server";
        try
        {
            if (serverChannel == null || !serverChannel.isConnected())
                serverChannel = SocketChannel.open(new InetSocketAddress(host, serverPort));

            if (serverChannel.isConnected())
            {
                ByteBuffer buffer = ByteBuffer.wrap(jsonStr.getBytes());
                serverChannel.write(buffer);
                buffer.clear();
                ByteBuffer buffer1 = ByteBuffer.allocate(2048);
                serverChannel.read(buffer1);
                buffer1.flip();
                message = new String(buffer1.array(), 0, buffer1.limit());
                JsonObject jsonObject1 = gson.fromJson(message, JsonObject.class);
                return Utility.getMessage(jsonObject1);
            }
        }
        catch (IOException e)
        {
            System.out.println("[ADMIN ERROR]: can't connect to server");
        }
        return message;
    }

    public static void main(String[] args) {
        new Admin();
    }
}
