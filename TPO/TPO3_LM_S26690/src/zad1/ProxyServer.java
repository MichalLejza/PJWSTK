package zad1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class ProxyServer
{
    private static final int localPort = Utility.getPort();
    private static Map<String, LanguageServer> languageServers;

    public ProxyServer()
    {
        try (ServerSocket serverSocket = new ServerSocket(localPort))
        {
            languageServers = new HashMap<>();
            while (true)
            {
                Socket socket = serverSocket.accept();
                Thread thread = new Thread(new RequestHandler(socket));
                thread.start();
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static boolean serverExists(String language)
    {
        return languageServers.containsKey(language);
    }

    public static LanguageServer getServer(String language) {
        return languageServers.get(language);
    }

    public static int getPort() {
        return localPort;
    }

    public static void addLanguageServer(String language, LanguageServer languageServer) {
        languageServers.put(language, languageServer);
    }
}