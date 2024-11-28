package PPJ.FirstSemester.Cwiczenia19;

public class Word
{
    char []tab;
    int x;

    public Word()
    {
        this.tab = new char[100];
        this.x = 0;
    }
    public void addChar(char znak)
    {
        tab[x] = znak;
        x ++;
    }
    public void show()
    {
        for(int i = 0; i < tab.length; i++)
            if(tab[i] != 0)
                System.out.print(tab[i] + " ");
        System.out.println();
    }
    public int length()
    {
        int count = 0;
        for(int i = 0; i < tab.length; i++)
            if(tab[i] != 0)
                count++;
        return count;
    }
}
