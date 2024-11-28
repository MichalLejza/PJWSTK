package PPJ.FirstSemester.Cwiczenia19;

public class Walec
{
    public int promien;
    public int wysokosc;

    public Walec(int promien, int wysokosc) {
        this.promien = promien;
        this.wysokosc = wysokosc;
    }

    public double polePowierzchni() {
        return (Math.PI * promien * promien * 2) + (2 * Math.PI * promien * wysokosc);
    }

    public double objetosc()
    {
        return (Math.PI * promien * promien * wysokosc);
    }

    public void show()
    {
        System.out.println("Pole powierzchni : " + polePowierzchni());
        System.out.println("Objetosc: " + objetosc());
    }
}
