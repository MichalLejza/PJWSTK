package PPJ.FirstSemester.Cwiczenia19;

public class KulaNa
{
    private double promien;

    public KulaNa(Kwadrat kwadrat)
    {
        this.promien = kwadrat.bok / 2 * Math.sqrt(2);
    }

    public KulaNa(Walec walec)
    {
        this.promien = Math.sqrt(walec.promien * walec.promien + walec.wysokosc * walec.wysokosc);
    }

    public void show()
    {
        double objetosc = 4/3 * Math.PI * promien * promien * promien;
        double pole = 4 * Math.PI * promien * promien;
        System.out.println("Pole powierzchni : " + pole);
        System.out.println("Objetosc: " + objetosc);
    }

}
