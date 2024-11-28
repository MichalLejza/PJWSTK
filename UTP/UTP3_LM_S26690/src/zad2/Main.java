/**
 *
 *  @author Lejza Michał S26690
 *
 */

package zad2;

import java.util.Arrays;
import java.util.List;


public class Main {

  public static void main(String[] args) {
    // Lista destynacji: port_wylotu port_przylotu cena_EUR 
    List<String> dest = Arrays.asList(
      "bleble bleble 2000",
      "WAW HAV 1200",
      "xxx yyy 789",
      "WAW DPS 2000",
      "WAW HKT 1000"
    );
    double ratePLNvsEUR = 4.30;
    List<String> result = 
    		dest.stream()
            .filter(n -> n.contains("WAW"))
            .map(n -> {
                String []s = n.split(" ");
                int d = Integer.parseInt(s[2]);
                d *= ratePLNvsEUR;
                return "to " + s[1] + " - price in PLN:   " + d;
            })
            .toList();

    for (String r : result) System.out.println(r);
  }
}
