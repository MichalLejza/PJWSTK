/**
 *
 *  @author Lejza Michał S26690
 *
 */

package zad1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/*<--
 *  niezbędne importy
 */
public class Main {
  public static void main(String[] args) {
    /*<--
     *  definicja operacji w postaci lambda-wyrażeń:
     *  - flines - zwraca listę wierszy z pliku tekstowego
     *  - join - łączy napisy z listy (zwraca napis połączonych ze sobą elementów listy napisów)
     *  - collectInts - zwraca listę liczb całkowitych zawartych w napisie
     *  - sum - zwraca sumę elmentów listy liczb całkowitych
     */
	  Function<String, List<String>> flines = path -> {
          try {
              return Files.lines(Paths.get(path))
                      .collect(Collectors.toList());
          } catch (IOException e) {
              throw new RuntimeException(e);
          }
      };
      Function<List<String>, String> join = lista -> lista.stream()
              .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
              .toString();
      Function<String, List<Integer>> collectInts = napis -> Pattern.compile("\\D+")
              .splitAsStream(napis)
              .filter(s -> !s.isEmpty())
              .map(Integer::parseInt)
              .collect(Collectors.toList());
      Function<List<Integer>, Integer> sum = list -> list.stream().mapToInt(Integer::intValue).sum();

    String fname = System.getProperty("user.home") + "/LamComFile.txt"; 
    InputConverter<String> fileConv = new InputConverter<>(fname);
    List<String> lines = fileConv.convertBy(flines);
    String text = fileConv.convertBy(flines, join);
    List<Integer> ints = fileConv.convertBy(flines, join, collectInts);
    Integer sumints = fileConv.convertBy(flines, join, collectInts, sum);

    System.out.println(lines);
    System.out.println(text);
    System.out.println(ints);
    System.out.println(sumints);

    List<String> arglist = Arrays.asList(args);
    InputConverter<List<String>> slistConv = new InputConverter<>(arglist);  
    sumints = slistConv.convertBy(join, collectInts, sum);
    System.out.println(sumints);

  }
}
