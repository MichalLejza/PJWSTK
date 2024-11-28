package GUI.Cwiczenia6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Student implements Comparable<Student>
{
    String imie;
    int numerGrupy;
    int wynik;
    public Student(String imie, String numerGrupy, String wynik)
    {
        this.imie = imie;
        this.wynik = Integer.parseInt(wynik);
        this.numerGrupy = changeToNumber(numerGrupy);
    }

    private int changeToNumber(String numerGrupy)
    {
        String wynik = "";

        for(int i = 0; i < numerGrupy.length(); i++)
            if(numerGrupy.charAt(i) >= '0' && numerGrupy.charAt(i) <= '9')
                wynik += numerGrupy.charAt(i);

        return Integer.parseInt(wynik);
    }

    public String toString()
    {
        return imie + "(" + numerGrupy + "c)-" + wynik;
    }

    @Override
    public int compareTo(Student o) {
        if(this.numerGrupy > o.numerGrupy)
            return 1;
        if(this.wynik > o.wynik)
            return 1;
        return -1;
    }

    public int getNumerGrupy()
    {
        return numerGrupy;
    }
}

public class Zadanie11
{
    public static void main(String[] args) throws IOException
    {
        String path = "/Users/michallejza/IdeaProjects/PJWSTK/src/GUI/Cwiczenia6/Plik.txt";
        Stream<Student> studenci = Files.lines(Path.of(path)).map(e -> { String []s = e.split(" "); return new Student(s[0], s[1], s[2]);});
        //studenci.filter(s -> s.wynik > 50).forEach(System.out::println);
        //studenci.filter(s -> s.wynik > 50).sorted().forEach(System.out::println);
        Map<Integer, List<Student>> map = studenci.collect(Collectors.groupingBy(Student::getNumerGrupy));
        System.out.println(map);
    }
}
