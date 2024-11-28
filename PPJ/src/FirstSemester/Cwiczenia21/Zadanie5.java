package PPJ.FirstSemester.Cwiczenia21;

public class Zadanie5
{
    static class DrzewoIglaste extends Zadanie4.Drzewo {
        private int iloscIgiel;
        private double dlugoscSzyszki;

        public DrzewoIglaste(boolean wiecznieZielone, int wysokosc, String przekrojDrzewa, int iloscIgiel, double dlugoscSzyszki) {
            super(wiecznieZielone, wysokosc, przekrojDrzewa);
            this.iloscIgiel = iloscIgiel;
            this.dlugoscSzyszki = dlugoscSzyszki;
        }

        public String toString() {
            String info = super.toString();
            info += ", posiadające " + this.iloscIgiel + " igieł";
            info += " i szyszki o długości " + this.dlugoscSzyszki + " cm";
            return info;
        }
    }

    static class DrzewoLisciaste extends Zadanie4.Drzewo {
        private int ksztaltLiscia;

        public DrzewoLisciaste(boolean wiecznieZielone, int wysokosc, String przekrojDrzewa, int ksztaltLiscia) {
            super(wiecznieZielone, wysokosc, przekrojDrzewa);
            this.ksztaltLiscia = ksztaltLiscia;
        }

        public String toString() {
            String info = super.toString();
            info += ", posiadające liście o kształcie " + this.ksztaltLiscia;
            return info;
        }
    }

    static class DrzewoOwocowe extends DrzewoLisciaste {
        private String nazwaOwoca;

        public DrzewoOwocowe(boolean wiecznieZielone, int wysokosc, String przekrojDrzewa, int ksztaltLiscia, String nazwaOwoca) {
            super(wiecznieZielone, wysokosc, przekrojDrzewa, ksztaltLiscia);
            this.nazwaOwoca = nazwaOwoca;
        }

        public String toString() {
            String info = super.toString();
            info += ", produkujące owoce o nazwie " + this.nazwaOwoca;
            return info;
        }
    }

    public static void main(String[] args)
    {
        DrzewoOwocowe owoc = new DrzewoOwocowe(true, 10, "40 cm", 10, "Jablko");
        System.out.println(owoc.toString());
    }
}
