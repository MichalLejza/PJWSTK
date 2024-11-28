package zad1;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Objects;

public class Client extends JFrame{
    private static final ArrayList<String> languages = Utility.getLanguages();
    private static final int serverPort = ProxyServer.getPort();
    private static final int localPort = Utility.getPort();
    private String language;

    public Client () {
        setTitle("TPO Project 3");
        setSize(440, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        JPanel translationPanel = new JPanel();
        translationPanel.setLayout(new FlowLayout());
        JTextField wordField = new JTextField(20);
        translationPanel.add(wordField);
        JComboBox<String> comboBox = new JComboBox<>(languages.toArray(new String[0]));
        comboBox.addActionListener(e -> {
            JComboBox<String> source = (JComboBox<String>) e.getSource();
            language = (String) source.getSelectedItem();
        });
        translationPanel.add(comboBox);
        JButton translationButton = new JButton("Translate");
        translationPanel.add(translationButton);
        JTextField translationResult = new JTextField(20);
        translationResult.setEditable(false);
        translationPanel.add(translationResult);
        translationButton.addActionListener(e ->
        {
            String word = wordField.getText();
            if (language != null && !Objects.equals(word, ""))
            {
                String result = sendRequest("Translation", language, word);
                translationResult.setText(result);
            }
        });
        panel.add(translationPanel);

        JPanel dictionaryPanel = new JPanel();
        dictionaryPanel.setLayout(new FlowLayout());
        JTextField newDictionaryName = new JTextField(5);
        dictionaryPanel.add(newDictionaryName);
        JButton newDictionaryButton = new JButton("Add New Dictionary");
        dictionaryPanel.add(newDictionaryButton);
        JTextField newDictionaryResult = new JTextField(30);
        newDictionaryResult.setEditable(false);
        dictionaryPanel.add(newDictionaryResult);
        newDictionaryButton.addActionListener(e->
        {
            String languageCode = newDictionaryName.getText();
            if (!Objects.equals(languageCode, ""))
            {
                String result = sendRequest("NewDictionary", languageCode, "");
                newDictionaryResult.setText(result);
                ArrayList<String> newLanguages = Utility.getLanguages();
                for (String l : languages)
                    newLanguages.remove(l);
                if (!newLanguages.isEmpty())
                    comboBox.addItem(newLanguages.get(0));
            }
        });
        panel.add(dictionaryPanel);

        add(panel);
        setVisible(true);
    }
    public String sendRequest(String mode, String languageCode, String word)
    {
        ClientRequest message;
        if (!Utility.validLanguage(languageCode))
            return languageCode + " Is Not Valid Language Code. Try Again";
        else
        {
            try
            {
                ClientRequest clientRequest = new ClientRequest(mode, word, languageCode, localPort);
                Utility.sendRequest(clientRequest, serverPort);

                ServerSocket serverSocket = new ServerSocket(localPort);
                Socket socket = serverSocket.accept();
                socket.setSoTimeout(4000);
                InputStream inputStream = socket.getInputStream();
                ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
                message = (ClientRequest) objectInputStream.readObject();
                objectInputStream.close();
                inputStream.close();
                serverSocket.close();
                socket.close();
            }
            catch (IOException e)
            {
                return "[CLIENT]: Error in transmitting: " + e.getMessage();
            }
            catch (ClassNotFoundException e)
            {
                throw new RuntimeException(e);
            }
        }
        return message.getWord();
    }
}
