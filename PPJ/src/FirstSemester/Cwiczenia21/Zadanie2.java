package PPJ.FirstSemester.Cwiczenia21;

public class Zadanie2
{
    static class Osoba
    {
        private String imie;
        public Osoba(String imie)
        {
            this.imie = imie;
        }
        public String getImie()
        {
            return imie;
        }

        public void wyswietl()
        {
            System.out.println("Imie" + imie);
        }
    }

    static class Spawacz extends Osoba
    {
        int stazPracy;
        public Spawacz(int stazPracy, String imie)
        {
            super(imie);
            this.stazPracy = stazPracy;
        }
        public void wyswietl()
        {
            System.out.println("Imie" + super.getImie() + " Staz " + stazPracy);
        }
    }

    public static void main(String[] args)
    {
        Osoba osoba = new Osoba("Jan");
        osoba.wyswietl();
    }
}
