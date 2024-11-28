package PPJ.FirstSemester.Cwiczenia16;

public class Zadanie1
{
    static boolean jestRowny(int [][]tab1, int [][]tab2)
    {
        if(tab1.length == tab2.length)
        {
            for(int i = 0; i < tab1.length; i++)
            {
                if(tab1[i].length == tab2[i].length)
                {
                    for(int j = 0; j < tab1[i].length; j++)
                    {
                        if(tab1[i][j] != tab2[i][j])
                            return false;
                    }
                }
                else
                {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
    public static void main(String[] args)
    {
        int [][]tab1 = { {1,2,3}, {1,2}, { 1,2,3}};
        int [][]tab2 = { {1,2,3}, {1,2}, { 1,2,4}};
        if(jestRowny(tab1,tab2))
            System.out.println("Takie same");
        else
            System.out.println("Rozne");
    }
}
