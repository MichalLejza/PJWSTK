package PPJ.FirstSemester.Cwiczenia21;

public class Zadanie4
{
    public static class Drzewo
    {
        private boolean wiecznieZielone;
        private int wysokosc;
        private String przekrojDrzewa;

        public Drzewo()
        {
            this.wiecznieZielone = false;
            this.wysokosc = 0;
            this.przekrojDrzewa = "";
        }

        public Drzewo(boolean wiecznieZielone, int wysokosc, String przekrojDrzewa)
        {
            this.wiecznieZielone = wiecznieZielone;
            this.wysokosc = wysokosc;
            this.przekrojDrzewa = przekrojDrzewa;
        }

        // metoda toString
        public String toString()
        {
            String info = "Drzewo o wysokości " + this.wysokosc + " m";
            if (this.wiecznieZielone) {
                info += " i zawsze zielone";
            } else {
                info += " i niezawsze zielone";
            }
            info += " o przekroju " + this.przekrojDrzewa;
            return info;
        }

        public static void main(String[] args)
        {
            Drzewo d1 = new Drzewo(true, 10, "okrągły");
            Drzewo d2 = new Drzewo(false, 15, "prostokątny");

            System.out.println(d1.toString());
            System.out.println(d2.toString());
        }
    }
}
