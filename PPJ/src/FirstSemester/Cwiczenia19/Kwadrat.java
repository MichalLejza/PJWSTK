package PPJ.FirstSemester.Cwiczenia19;

public class Kwadrat
{
    public int bok;

    public Kwadrat(int v)
    {
        this.bok = v;
    }

    public void show()
    {
        System.out.println("Pole powierzchni: " + bok * bok );
        System.out.println("Objetosc szescianu: " + bok * bok * bok);
    }
}
