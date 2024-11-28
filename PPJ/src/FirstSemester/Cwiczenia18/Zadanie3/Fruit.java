package PPJ.FirstSemester.Cwiczenia18.Zadanie3;

public class Fruit
{
    String name;
    double weight;

    public Fruit(String name)
    {
        this.name = name;
        this.weight = (Math.random() * 0.3 + 0.5);
    }
     public void show()
     {
         System.out.println("Nazwa: " + name);
         System.out.println("Waga: " + weight);
     }
}
