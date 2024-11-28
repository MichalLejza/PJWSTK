package org.example;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import javax.naming.NamingException;
import javax.swing.*;
import java.awt.*;

public class Client extends JFrame
{
    private final JTextField textField;
    private final JTextArea textArea;
    private final JTextField userNameField;
    private final JButton selectButton;
    private final JLabel userNameLabel;

    private String userName = "";

    private Session session;
    private MessageProducer producer;

    public Client()
    {
        try
        {
            initializeJMS();
        }
        catch (JMSException | NamingException e)
        {
            System.out.println(e.getMessage());
            System.exit(1);
        }

        setTitle("TPO Project 6");
        setSize(400, 400);
        setLayout(new BorderLayout());

        JPanel userNamePanel = new JPanel(new FlowLayout());
        userNameField = new JTextField(20);
        selectButton = new JButton("Select");
        userNameLabel = new JLabel();
        userNameLabel.setVisible(false);
        userNamePanel.add(userNameField);
        userNamePanel.add(selectButton);
        userNamePanel.add(userNameLabel);
        add(userNamePanel, BorderLayout.NORTH);

        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(scrollPane, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new FlowLayout());
        textField = new JTextField(20);
        JButton sendButton = new JButton("Send");
        bottomPanel.add(textField);
        bottomPanel.add(sendButton);
        add(bottomPanel, BorderLayout.SOUTH);

        selectButton.addActionListener(e ->
        {
            String text = userNameField.getText();
            if (!text.isEmpty())
            {
                userName = text;
                selectButton.setVisible(false);
                userNameField.setVisible(false);
                userNameLabel.setText(text);
                userNameLabel.setVisible(true);
            }

        });

        sendButton.addActionListener(e ->
        {
            String message = textField.getText();
            if (!message.isEmpty() && !userName.isEmpty())
                sendMessage(message);
        });
        setVisible(true);
    }

    private void sendMessage(String text)
    {
        try
        {
            TextMessage message = session.createTextMessage(userName + ": " + text);
            producer.send(message);
        }
        catch (JMSException e)
        {
            System.out.println(e.getMessage());
        }
    }

    private void initializeJMS() throws JMSException, NamingException {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        Connection connection = connectionFactory.createConnection();
        connection.start();
        session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Topic topic = session.createTopic("ChatTopic");
        producer = session.createProducer(topic);
        MessageConsumer consumer = session.createConsumer(topic);
        consumer.setMessageListener(message -> {
            try
            {
                if (message instanceof TextMessage)
                {
                    TextMessage textMessage = (TextMessage) message;
                    textArea.append(textMessage.getText() + "\n");
                }
            } catch (JMSException e)
            {
                System.out.println(e.getMessage());
            }
        });
    }
}
