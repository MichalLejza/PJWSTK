package PPJ.FirstSemester.Cwiczenia20;

public class Person
{
    String name;
    int birthYear;

    public Person(String name, int birthYear)
    {
        this.name = name;
        this.birthYear = birthYear;
    }

    public Person(String name)
    {
        this.birthYear = 1990;
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public int getAge()
    {
        return 2022 - birthYear;
    }

    static Person getOlder(Person p1, Person p2)
    {
        if(p1.getAge() > p1.getAge())
            return p1;
        return p2;
    }

    static Person getOldest(Person []ludzie)
    {
        Person wynik = new Person("", 2022);
        for(int i = 0; i < ludzie.length; i++)
        {
            wynik = wynik.getAge() > ludzie[i].getAge() ? wynik : ludzie[i];
        }
        return wynik;
    }
}
