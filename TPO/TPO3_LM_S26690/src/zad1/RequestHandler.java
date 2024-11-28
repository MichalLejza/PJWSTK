package zad1;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.Socket;

public class RequestHandler implements Runnable
{
    private final Socket socket;

    public RequestHandler(Socket socket)
    {
        this.socket = socket;
    }

    @Override
    public void run()
    {
        try
        {
            InputStream inputStream = socket.getInputStream();
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            ClientRequest clientRequest = (ClientRequest) objectInputStream.readObject();
            objectInputStream.close();
            inputStream.close();
            socket.close();

            switch (clientRequest.getMode())
            {
                case "Translation" -> requestTranslation(clientRequest);
                case "NewDictionary" -> createNewDictionary(clientRequest);
                case "SendTranslation" -> returnTranslationToClient(clientRequest);
            }
        }
        catch (IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    private void requestTranslation(ClientRequest clientRequest)
    {
        if (!ProxyServer.serverExists(clientRequest.getLanguageCode()))
        {
            LanguageServer languageServer = new LanguageServer();
            ProxyServer.addLanguageServer(clientRequest.getLanguageCode(), languageServer);
            Thread thread = new Thread(languageServer::start);
            thread.start();
        }
        LanguageServer languageServer = ProxyServer.getServer(clientRequest.getLanguageCode());
        clientRequest.setMode("SendTranslation");
        Utility.sendRequest(clientRequest, languageServer.getPort());
    }

    private void createNewDictionary(ClientRequest clientRequest)
    {
        String message = Utility.createDictionary(clientRequest.getLanguageCode());
        clientRequest.setWord(message);
        Utility.sendRequest(clientRequest, clientRequest.getPort());
    }

    private void returnTranslationToClient(ClientRequest clientRequest)
    {
        String word = Utility.getTranslation(clientRequest.getWord(), clientRequest.getLanguageCode());
        clientRequest.setWord(word);
        Utility.sendRequest(clientRequest, clientRequest.getPort());
    }
}
