package PPJ.FirstSemester.Cwiczenia11;

public class Zadanie2
{
    static int max(int a, int b)
    {
        return (a > b ? a : b);
    }

    static void printArray(int []tab)
    {
        for(int i : tab)
        {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    // scalamy dwie tablice

    static void pierwszyPodpunkt(int []arr1, int []arr2)
    {
        int size_new = arr1.length + arr2.length;
        int []suma = new int[size_new];

        int index = 0;
        int i = 0;

        while(i < arr1.length)
        {
            suma[index] = arr1[i];
            i++;
            index++;
        }

        i = 0;
        while (i < arr2.length)
        {
            suma[index] = arr2[i];
            i++;
            index++;
        }
        System.out.println("Suma:");
        printArray(suma);
    }

    // iloczyn zbiorow czyli dwoch tablic

    static void drugiPodpunkt(int []arr1, int []arr2)
    {
        int rozmiar_one = 0;
        int rozmiar_two = 0;
        for (int j : arr1) rozmiar_one = max(rozmiar_one, j);
        for (int j : arr2) rozmiar_two = max(rozmiar_two, j);

        int[] wystapienia_one = new int[rozmiar_one + 1];
        int[] wystapienia_two = new int[rozmiar_two + 1];

        for (int i : arr1) wystapienia_one[i]++;
        for (int i : arr2) wystapienia_two[i]++;

        int i = 0;
        int j = 0;
        int count = 0;

        while (i < wystapienia_one.length && j < wystapienia_two.length) {
            if (wystapienia_one[i] != 0 && wystapienia_two[j] != 0)
                count++;
            i++;
            j++;
        }

        int[] iloczyn = new int[count];
        i = 0;
        j = 0;
        int index = 0;

        while (i < wystapienia_one.length && j < wystapienia_two.length) {
            if (wystapienia_one[i] != 0 && wystapienia_two[j] != 0) {
                iloczyn[index] = i;
                index++;
            }
            i++;
            j++;
        }
        System.out.println("Iloczyn");
        printArray(iloczyn);
    }

    static void trzeciPodpunkt(int []arr1, int []arr2)
    {
        int max_arr1 = 0;
        int max_arr2 = 0;
        for(int i : arr1) max_arr1 = max(max_arr1, i);
        for(int i : arr2) max_arr2 = max(max_arr2, i);

        int size = max(max_arr1, max_arr2);
        int []wystapienia = new int[size + 1];

        for(int i : arr1) wystapienia[i]++;
        for(int i : arr2) wystapienia[i]++;

        int poc = 0;
        int kon = wystapienia.length - 1;

        while(poc < wystapienia.length && wystapienia[poc] != 0)
            poc++;

        while (kon >= 0 && wystapienia[kon] != 0)
            kon--;

        size = kon - poc + 1;
        int []negacja = new int[size];
        for(int i = 0; i < negacja.length; i++)
        {
            negacja[i] = poc;
            poc++;
        }
        System.out.println("Trzeci podpunkt:");
        printArray(negacja);
    }

    public static void main(String[] args)
    {
        int []arr1 = new int[10];
        int []arr2 = new int[8];

        for(int i = 0; i < arr1.length; i++)
        {
            arr1[i] = (int)(Math.random() * 20);
        }

        for(int i = 0; i < arr2.length; i++)
        {
            arr2[i] = (int)(Math.random() * 20);
        }

        System.out.println("Pierwsza tablica: ");
        printArray(arr1);

        System.out.println("Druga tablica: ");
        printArray(arr2);

        int size_new = arr1.length + arr2.length;
        int []suma = new int[size_new];
        pierwszyPodpunkt(arr1,arr2);
        drugiPodpunkt(arr1,arr2);
        trzeciPodpunkt(arr1,arr2);
    }
}
