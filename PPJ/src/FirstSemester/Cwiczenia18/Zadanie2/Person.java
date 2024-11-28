package PPJ.FirstSemester.Cwiczenia18.Zadanie2;

public class Person
{
    public String name;
    public String surname;
    public int birthyear;

    public Person(String name, String surname, int birthyear)
    {
        this.name = name;
        this.surname = surname;
        this.birthyear = birthyear;
    }

    public void showPerson()
    {
        System.out.println("Imie: " + name);
        System.out.println("Nazwisko: " + surname);
        System.out.println("Rok urodzenia: " + birthyear);
        System.out.println();
    }

}
