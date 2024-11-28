/**
 *
 *  @author Lejza Michał S26690
 *
 */

package zad1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Anagrams
{
    String input;
    List<String> rows;

    public Anagrams(String input) {
        this.rows = new ArrayList<>();
        this.input = input;
        getText();
    }

    private void getText() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(input));
            String line;
            while((line = br.readLine()) != null)
                this.rows.addAll(Arrays.asList(line.split(" ")));
            br.close();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private boolean areWordsAnagrams(String one, String two) {
        TreeSet<String> setOne = new TreeSet<>(Arrays.asList(one.split("")));
        TreeSet<String> setTwo = new TreeSet<>(Arrays.asList(two.split("")));
        return setOne.equals(setTwo);
    }

    public List<List<String>> getSortedByAnQty() {
        ArrayList<ArrayList<String>> output = new ArrayList<>();

        for (String word : this.rows) {
            boolean found = false;

            for (ArrayList<String> list: output) {
                String listWord = list.get(0);

                if (this.areWordsAnagrams(listWord, word)) {
                    list.add(word);
                    found = true;
                    break;
                }
            }

            if (!found) {
                ArrayList<String> newList = new ArrayList<>();
                newList.add(word);
                output.add(newList);
            }
        }

        return output
                .stream()
                .sorted((el1, el2) -> {
                    if (el2.size() - el1.size() == 0)
                        return el1.get(0).compareTo(el2.get(0));
                    return el2.size() - el1.size();
                })
                .collect(Collectors.toList());
    }

    public String getAnagramsFor(String searchedWord) {
        List<String> list = this
                .getSortedByAnQty()
                .stream()
                .filter((el) -> this.areWordsAnagrams(searchedWord, el.get(0)))
                .findAny()
                .orElse(null);

        if (list == null)
            return searchedWord + ": null";

        List<String> listWithout = list
                .stream()
                .filter(el -> !el.equals(searchedWord))
                .collect(Collectors.toList());
        return searchedWord + ": " + listWithout;
    }
}  
