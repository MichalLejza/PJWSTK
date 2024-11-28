package zad1;

import javax.swing.*;

public class Main
{
    public static void main(String[] args)
    {
        Thread serverThread = new Thread(ProxyServer::new);
        serverThread.start();
        SwingUtilities.invokeLater(Client::new);
    }
}
