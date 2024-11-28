package GUI.Cwiczenia5;


import java.util.ArrayList;
import java.util.HashMap;

class Samochod
{
    String marka;
    int cena;

    public Samochod(String marka, int cena)
    {
        this.cena = cena;
        this.marka = marka;
    }

    @Override
    public String toString()
    {
        return this.marka + " " + this.cena;
    }
}

public class Zadanie10
{
    public static void main(String[] args)
    {
        String[] arr = {
                "salon A", "Mercedes", "130000",
                "salon B", "Mercedes", "120000",
                "salon C", "Ford", "110000",
                "salon B", "Opel", "90000",
                "salon C", "Honda", "95000",
                "salon A", "Ford", "105000",
                "salon A", "Renault", "75000"
        };

        HashMap<String , ArrayList<Samochod>> cars = new HashMap<>();
        for(int i = 0; i < arr.length; i += 3)
        {
            if(!cars.containsKey(arr[i]))
            {
                ArrayList<Samochod> car = new ArrayList<>();
                car.add(new Samochod(arr[i + 1], Integer.parseInt(arr[i + 2])));
                cars.put(arr[i], car);
            }
            else
            {
                ArrayList<Samochod> car = cars.get(arr[i]);
                car.add(new Samochod(arr[i + 1], Integer.parseInt(arr[i + 2])));
                cars.remove(arr[i]);
                cars.put(arr[i], car);
            }
        }

        for(String s : cars.keySet())
        {
            System.out.print(s + " ");
            System.out.println(cars.get(s).toString());
        }
    }
}
