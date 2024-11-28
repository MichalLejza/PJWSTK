package PPJ.FirstSemester.Cwiczenia20;

public class Main
{
    static void Zadanie1()
    {
        Ball pilka = new Ball();
        pilka.makeBall();
        pilka.makeBall();
        System.out.println(pilka.ballCounter);
    }

    static void Zadanie2()
    {
        Person p1 = new Person("Jas", 1999);
        Person p2 = new Person("Zdzis", 1998);
        Person p3 = new Person("Kaja", 1989);
        Person p4 = new Person("Kajtek", 1934);
        Person p5 = new Person("Andrzej", 2002);
        Person older = Person.getOlder(p1,p2);
        System.out.println("Older : " + older.getAge());
        Person []ludzie = {p1,p2,p3,p4,p5};
        System.out.println("Oldest : " + Person.getOldest(ludzie).getAge());
    }

    static void Zadanie3()
    {
        MyQueue kolejka = new MyQueue();
        String []koszykA = {"PSG", "Atletico Madryt", "Sporting CP", "Inter", "Benfica", "Villarreal", "RB Salzburg", "Chelsea"};
        String []koszykB = {"Manchester City", "Liverpool", "Ajax Amsterdam", "Real Madryt", "Bayern Monachium", "Manchester United", "Lille", "Juventus"};
        int index = 0;
        int a = 0;
        int b = 0;
        for(int i = 0; i < koszykA.length + koszykB.length; i++)
        {
            if(i % 2 == 0)
            {
                kolejka.push(koszykA[a]);
                a++;
            }
            else
            {
                kolejka.push(koszykB[b]);
                b++;
            }
        }
        //kolejka.printQueue();
        while (!kolejka.isEmpty())
        {
            System.out.print(kolejka.frontElement() + " i ");
            kolejka.pop();
            System.out.println(kolejka.frontElement());
            kolejka.pop();
        }
    }

    public static void main(String[] args)
    {

        Zadanie1();
        Zadanie2();
        Zadanie3();
    }
}
