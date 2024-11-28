package PPJ.FirstSemester.Cwiczenia22Dodatkowe;

public class Zadanie6
{
    static abstract class CipherGenerator
    {
        public String codename;
        public String name;

        public abstract String encrypt(String code);

        public abstract String decrypt(String code);

        public boolean isItASpace(char c)
        {
            return (c == ' ');
        }

        public boolean isItADot(char c)
        {
            return (c == '.');
        }

        public boolean isItADash(char c)
        {
            return (c == '-');
        }

        public boolean isItABigLetter(char c)
        {
            return (c >= 65 && c <= 90);
        }

        public boolean isItASmallLetter(char c)
        {
            return (c >= 97 && c <= 122);
        }

        public boolean isItALetter(char c)
        {
            return (c >= 97 && c <= 122 || c >= 65 && c <= 90);
        }
    }

    static class MorseCodeCipherGenerator extends CipherGenerator
    {
        String[] znaki = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.",
                            "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        @Override
        public String encrypt(String code)
        {
            String encypted = "";
            for(int i = 0; i < code.length(); i++)
            {
                int index = 0;
                if(isItABigLetter(code.charAt(i)))
                {
                    index = (int)code.charAt(i) - 65;
                }
                else if(isItASmallLetter(code.charAt(i)))
                {
                    index = (int)code.charAt(i) - 97;
                }
                encypted += znaki[index];
                encypted += " ";
            }
            return encypted;
        }

        boolean compareStrings(String one, String two)
        {
            if(one.length() == two.length())
            {
                for(int i = 0; i < one.length(); i++)
                    if(one.charAt(i) != two.charAt(i))
                        return false;
                return true;
            }
            return false;
        }

        int indexMorse(String code)
        {
            int index = -1;
            for(int i = 0; i < znaki.length; i++)
            {
                if(code.length() == znaki[i].length())
                {
                    for(int j = 0; j < znaki[i].length(); j++)
                        if(code.charAt(j) != znaki[i].charAt(j))
                            continue;
                    index = i;
                }
            }
            return index;
        }

        @Override
        public String decrypt(String code)
        {
            String decrypted = "";
            for(int i = 0; i < code.length(); i++)
            {

            }
            return decrypted;
        }
    }

    static class CesarCodeCipherGenerator extends CipherGenerator
    {
        @Override
        public String encrypt(String code)
        {
            String encypted = "";
            for(int i = 0; i < code.length(); i++)
            {
                if(isItALetter(code.charAt(i)))
                {
                    char add = (char)((int)code.charAt(i) + 1);
                    if(!isItALetter(add))
                        add -= 26;
                    encypted += add;
                }
            }
            return encypted;
        }

        @Override
        public String decrypt(String code)
        {
            String decrypted = "";
            for(int i = 0; i < code.length(); i++)
            {
                if(isItALetter(code.charAt(i)))
                {
                    char add = (char)((int)code.charAt(i) - 1);
                    if(!isItALetter(add))
                        add += 26;
                    decrypted += add;
                }
            }
            return decrypted;
        }
    }

    public static void main(String[] args)
    {
        CesarCodeCipherGenerator cezar = new CesarCodeCipherGenerator();
        System.out.println(cezar.encrypt("Hello"));
        System.out.println(cezar.decrypt(cezar.encrypt("Hello")));

        MorseCodeCipherGenerator morse = new MorseCodeCipherGenerator();
        System.out.println(morse.encrypt("Hello"));
    }

}
