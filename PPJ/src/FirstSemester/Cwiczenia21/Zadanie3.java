package PPJ.FirstSemester.Cwiczenia21;

public class Zadanie3
{
    static class Pojazd {
        // pole klasy
        protected String color;

        // konstruktor
        public Pojazd(String color) {
            this.color = color;
        }
    }

    static class PojazdKolowy extends Pojazd {
        // prywatne pole klasy
        private int iloscOsi;

        // konstruktor
        public PojazdKolowy(String color, int iloscOsi) {
            super(color);
            this.iloscOsi = iloscOsi;
        }

        public int getIloscOsi()
        {
            return iloscOsi;
        }
    }

    static class CiagnikSiodlowy extends PojazdKolowy {
        // pole klasy
        protected int masa;

        // konstruktor
        public CiagnikSiodlowy(String color, int iloscOsi, int masa) {
            super(color, iloscOsi);
            this.masa = masa;
        }

        // metoda
        public void rozpocznijJazde() {
            int naciskNaOse = this.masa / this.getIloscOsi();
            if (naciskNaOse > 11) {
                System.out.println("Jazda niebezpieczna, odmowa uruchomienia silnika");
            } else {
                System.out.println("Silnik uruchomiony, można rozpocząć jazdę");
            }
        }
    }

    public static void main(String[] args) {
        CiagnikSiodlowy c1 = new CiagnikSiodlowy("czerwony", 2, 12000);
        CiagnikSiodlowy c2 = new CiagnikSiodlowy("niebieski", 4, 8000);

        c1.rozpocznijJazde();
        c2.rozpocznijJazde();
    }
}
