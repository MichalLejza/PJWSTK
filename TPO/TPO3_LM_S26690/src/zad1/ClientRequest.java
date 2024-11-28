package zad1;

import java.io.Serializable;

public class ClientRequest implements Serializable
{
    private String word;
    private String mode;
    private final String languageCode;
    private final int port;

    public ClientRequest(String mode, String word, String languageCode, int port)
    {
        this.mode = mode;
        this.word = word;
        this.languageCode = languageCode;
        this.port = port;
    }

    public void setWord(String word)
    {
        this.word = word;
    }

    public void setMode(String mode)
    {
        this.mode = mode;
    }

    public String getMode()
    {
        return this.mode;
    }

    public String getWord()
    {
        return this.word;
    }

    public String getLanguageCode()
    {
        return this.languageCode;
    }

    public int getPort()
    {
        return this.port;
    }
}
