package GUI.Cwiczenia6;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Slowa implements Iterable<Map.Entry<String, Integer>>, Map.Entry<String, Integer>
{
    String pathName;
    Integer value;
    String key;

    public Slowa(String pathName)
    {
        this.pathName = pathName;
    }

    @Override
    public Iterator<Map.Entry<String, Integer>> iterator()
    {
        try
        {
            Stream<String> lines = Files.lines(Paths.get(pathName), StandardCharsets.UTF_8);
            Map wordCountMap = lines
                    .flatMap(line -> Arrays.stream(line.split("[^\\p{IsAlphabetic}]+")))
                    .collect(Collectors.groupingBy(String::toUpperCase, Collectors.counting()));

            lines.close();

            return wordCountMap.entrySet().iterator();
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getKey()
    {
        return key;
    }

    @Override
    public Integer getValue()
    {
        return value;
    }

    @Override
    public Integer setValue(Integer value)
    {
        Integer old = this.value;
        this.value = value;
        return old;
    }
}

public class Zadanie12
{
    public static void main(String[] args)
    {
        String file = "/Users/michallejza/IdeaProjects/PJWSTK/src/GUI/Cwiczenia6/Slowa.txt";
        for (Map.Entry<String, Integer> e : new Slowa(file))
            System.out.println(
                    e.getKey() + " -> " + e.getValue());
    }
}