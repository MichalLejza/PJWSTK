package PPJ.FirstSemester.Cwiczenia13;

public class Zadanie2
{
    static void printArray(int []tab)
    {
        for(int i : tab)
            System.out.print(i + " ");
        System.out.println();
    }

    static void scalTablice(int []A, int []B, int []C)
    {
        int a = 0;
        int b = B.length - 1;
        int index_c = 0;

        while(a < A.length && b >= 0)
        {
            if(A[a] > B[b])
            {
                C[index_c] = B[b];
                b--;
                index_c++;
            }
            else if(A[a] <= B[b])
            {
                C[index_c] = A[a];
                a++;
                index_c++;
            }
        }
        System.out.println(a == A.length);
        System.out.println(b);
        if(a == A.length)
        {
            while (b != -1)
            {
                C[index_c] = B[b];
                b--;
                index_c++;
            }
        }
        if(b == -1)
        {
            while (a != A.length)
            {
                C[index_c] = A[a];
                a++;
                index_c++;
            }
        }
    }

    public static void main(String[] args)
    {
        int []A = {1,3,5,7,9,11};
        int []B = {16,14,12,10,8,6,4,2,0};
        int []C = new int[A.length + B.length];
        scalTablice(A,B,C);
        printArray(C);
    }
}
