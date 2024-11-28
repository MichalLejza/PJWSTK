package GUI.Cwiczenia3;

interface Flyable
{
    String drive();
    double distance();
    static Flyable hybrid(Flyable a, Flyable b)
    {
        Flyable fly = new Flyable()
        {
            @Override
            public String drive()
            {
                return a.drive() + " " + b.drive();
            }

            @Override
            public double distance() {
                return Math.max(a.distance(), b.distance());
            }
        };
        return fly;
    }
}

interface Speakable
{
    String speak();
}

class Virus implements Flyable
{
    private double dystans;
    private String naped;

    public Virus(String naped, double dystans)
    {
        this.dystans = dystans;
        this.naped = naped;
    }
    @Override
    public String drive() {
        return naped;
    }

    @Override
    public double distance() {
        return dystans;
    }
}

class Bird implements Flyable, Speakable
{

    private double dystans;
    private String naped;
    private String dzwiek;

    public Bird(String naped, double dystans, String dzwiek)
    {
        this.dystans = dystans;
        this.naped = naped;
        this.dzwiek = dzwiek;
    }
    @Override
    public String drive() {
        return naped;
    }

    @Override
    public double distance() {
        return dystans;
    }

    @Override
    public String speak() {
        return dzwiek;
    }
}

class Plane implements Flyable, Speakable
{

    private double dystans;
    private String naped;
    private String dzwiek;

    public Plane(String naped, double dystans, String dzwiek)
    {
        this.dystans = dystans;
        this.naped = naped;
        this.dzwiek = dzwiek;
    }
    @Override
    public String drive() {
        return naped;
    }

    @Override
    public double distance() {
        return dystans;
    }

    @Override
    public String speak() {
        return dzwiek;
    }
}

class UFO implements Flyable, Speakable
{
    private double dystans;
    private String naped;
    private String dzwiek;

    public UFO(String naped, double dystans, String dzwiek)
    {
        this.dystans = dystans;
        this.naped = naped;
        this.dzwiek = dzwiek;
    }

    @Override
    public String drive() {
        return naped;
    }

    @Override
    public double distance() {
        return dystans;
    }

    @Override
    public String speak() {
        return dzwiek;
    }
}

public class Zadanie4
{
    static Speakable loudestObject(Speakable []obiekty)
    {
        int index = 0;
        for(int i = 0; i < obiekty.length; i++)
            if(obiekty[index].speak().length() < obiekty[i].speak().length())
                index = i;
        return obiekty[index];
    }

    static Flyable shortestDistance(Flyable []obiekty)
    {
        int index = 0;
        for(int i = 0; i < obiekty.length; i++)
            if(obiekty[index].distance() > obiekty[i].distance())
                index = i;
        return obiekty[index];
    }

    public static void main(String[] args)
    {
        UFO ufo1 = new UFO("silnik nuklearny", 10000, "WZIUUUUUu");
        Plane plane1 = new Plane("Silnik odrzutowy", 1000, "BRRR");
        Bird bird1 = new Bird("Skrzydla", 50, "cwirk");
        Virus virus1 = new Virus("Wiatr", 0.01);
        Flyable hybryda = Flyable.hybrid(ufo1, plane1);

        Flyable obiekty1[] = {ufo1, plane1, bird1, virus1, hybryda};
        Speakable obiekty2[] = {bird1, ufo1, plane1};

        Flyable shortest = shortestDistance(obiekty1);
        System.out.println(shortest.distance());

        Speakable speak = loudestObject(obiekty2);
        System.out.println(speak.speak());

    }
}

