package zad1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class LanguageServer
{
    public int port;
    public static String host;
    ServerSocket serverSocket;
    public LanguageServer()
    {
        try
        {
            port = Utility.getPort();
            host = Utility.getHost();
            serverSocket = new ServerSocket(port);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void start()
    {
        try
        {
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
    public int getPort()
    {
        return port;
    }

}
