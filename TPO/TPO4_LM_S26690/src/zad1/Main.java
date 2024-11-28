package zad1;

import javax.swing.*;

public class Main
{
    public static void main(String[] args)
    {
        Thread thread = new Thread(Server::new);
        thread.start();
        SwingUtilities.invokeLater(Admin::new);
        SwingUtilities.invokeLater(Client::new);
    }
}
