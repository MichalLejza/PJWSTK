package PPJ.FirstSemester.Cwiczenia21;

public class Zadanie1
{
    static class Prostokat
    {
        private int bokJeden;
        private int bokDwa;
        public Prostokat(int bokJeden, int bokDwa)
        {
            this.bokDwa = bokDwa;
            this.bokJeden = bokJeden;
        }
        public void show()
        {
            System.out.println("Prostokat bok jeden: " + bokJeden + " bok dwa " + bokDwa);
            System.out.println("Pole + " + bokJeden * bokDwa);
        }

        public int getBokJeden()
        {
            return bokJeden;
        }

        public int getBokDwa()
        {
            return bokDwa;
        }
    }

    static class Prostopadloscian extends Prostokat
    {
        private int wysokosc;
        public Prostopadloscian(int bokJeden, int bokDwa, int wysokosc)
        {
            super(bokJeden, bokDwa);
            this.wysokosc = wysokosc;
        }

        public Prostopadloscian(Prostokat prostokat, int wysokosc)
        {
            super(prostokat.getBokJeden(), prostokat.getBokDwa());
            this.wysokosc = wysokosc;
        }

        public void show()
        {
            System.out.println("Prostopadłościan: bok jeden" + getBokJeden() + " bok dwa: " + getBokDwa() + " WYsokosc: "+ wysokosc);
            System.out.println("Pole: " + getBokDwa() * getBokJeden() * 2 + 2 * getBokDwa() * wysokosc + 2 * getBokDwa() * wysokosc
                    + "  Objetosc " + getBokDwa() * getBokJeden() * wysokosc);
        }
    }

    static class Trojkat
    {
        private int bok;
        public Trojkat(int bok)
        {
            this.bok = bok;
        }

        public int getBok()
        {
            return bok;
        }

        public void show()
        {
            System.out.println("Trojkat: bok" + bok);
            System.out.println("Pole : " + bok * bok * Math.sqrt(3) / 4);
        }
    }

    static class Ostroslop extends Trojkat
    {
        private int wysokosc;
        public Ostroslop(int wysokosc, int bok)
        {
            super(bok);
            this.wysokosc = wysokosc;
        }

        public Ostroslop(Trojkat trojkat, int wysokosc)
        {
            super(trojkat.getBok());
            this.wysokosc = wysokosc;
        }

        public void show()
        {
            System.out.println("Ostroslop: bok" + getBok() + " wysokosc " + wysokosc);
            System.out.println("Pole ");
        }
    }

    static class Granisastoslop extends Trojkat
    {
        private int wysokosc;
        public Granisastoslop(int wysokosc, int bok)
        {
            super(bok);
            this.wysokosc = wysokosc;
        }

        public Granisastoslop(Trojkat trojkat, int wysokosc)
        {
            super(trojkat.getBok());
            this.wysokosc = wysokosc;
        }

        public void show()
        {
            System.out.println("Granisatoslop: bok" + getBok() + " wysokosc " + wysokosc);
        }
    }

    public static void main(String[] args)
    {
        Trojkat trojkat = new Trojkat(10);
        trojkat.show();
    }
}
