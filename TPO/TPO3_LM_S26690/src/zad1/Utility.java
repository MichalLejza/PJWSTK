package zad1;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Properties;

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

    public static boolean dictionaryExists(String language)
    {
        String pathName = System.getProperty("user.dir") + "/src/zad1/Data/" + language + ".properties";
        File file = new File(pathName);
        return file.exists();
    }

    public static int getPort()
    {
        ServerSocket socket;
        try
        {
            socket = new ServerSocket(0);
            socket.setReuseAddress(true);
            int port = socket.getLocalPort();
            socket.close();
            return port;
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        throw new IllegalStateException("Could not find a free TCP/IP port");
    }

    public static String createDictionary(String fileName)
    {
        String filePath = System.getProperty("user.dir") + "/src/zad1/Data/" + fileName + ".properties";
        try
        {
            File file = new File(filePath);
            if (file.createNewFile())
            {
                return "Dictionary: " + fileName + " created";
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return fileName + " dictionary already exists";
    }

    public static ArrayList<String> getLanguages()
    {
        String pathname = System.getProperty("user.dir") + "/src/zad1/Data/";
        ArrayList<String> languages = new ArrayList<>();
        File directory = new File(pathname);
        File []files = directory.listFiles();
        if (files != null)
            for (File file : files)
                if (file.isFile())
                    languages.add(file.getName().substring(0, file.getName().lastIndexOf('.')));
        return languages;
    }

    public static String getTranslation(String word, String language)
    {
        Properties properties = new Properties();
        FileInputStream input;
        try
        {
            String pathname = System.getProperty("user.dir") + "/src/zad1/Data/" + language + ".properties";
            input = new FileInputStream(pathname);
            properties.load(input);
            String translation = properties.getProperty(word);
            return translation == null ? "No word in dictionary" : translation;
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return "Dictionary doesnt exist yet";
    }

    public static void sendRequest(ClientRequest clientRequest, int port)
    {
        try
        {
            Socket socket = new Socket(Utility.getHost(), port);
            OutputStream outputStream = socket.getOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(clientRequest);
            objectOutputStream.close();
            outputStream.close();
            socket.close();
        }
        catch (IOException exc)
        {
            exc.printStackTrace();
        }
    }

    public static boolean validLanguage(String languageCode)
    {
        Locale[] locales = Locale.getAvailableLocales();
        for (Locale locale : locales)
            if (languageCode.equals(locale.getLanguage()))
                return true;
        return false;
    }
}
