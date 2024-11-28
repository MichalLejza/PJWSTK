/**
 *
 *  @author Lejza Michał S26690
 *
 */

package zad2;



import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Comparator;

public class CustomersPurchaseSortFind {
    private ArrayList<Purchase> records;

    private Comparator<Purchase> getFilter(String filter) {
        if (filter.equals("Nazwiska")) {
            return (one, two) -> {
                if (one.surname.compareTo(two.surname) == 0)
                    return one.id.compareTo(two.id);
                return one.surname.compareTo(two.surname);
            };
        }

        if (filter.equals("Koszty")) {
            return (one, two) -> {
                if ((int) Math.ceil(two.getCost() - one.getCost()) == 0)
                    return one.id.compareTo(two.id);
                return (int) Math.ceil(two.getCost() - one.getCost());
            };
        }
        return (one, two) -> 0;
    }

    public void readFile(String path) {
        this.records = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line;
            while((line = br.readLine()) != null)
                this.records.add(new Purchase(line));
            br.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showSortedBy(String filter) {
        System.out.println(filter);
        this.records
                .stream()
                .sorted(this.getFilter(filter))
                .forEach(p -> System.out.println(
                        p.toString(
                                filter.equals("Koszty")
                        )
                ));
        System.out.println();
    }

    public void showPurchaseFor(String id) {
        System.out.println("Klient " + id);
        this.records
                .stream()
                .filter((p) -> p.id.equals(id))
                .forEach(System.out::println);
        System.out.println();
    }
}