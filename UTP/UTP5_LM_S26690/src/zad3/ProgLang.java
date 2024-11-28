package zad3;


import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ProgLang {
    private final ArrayList<String> rows;

    public ProgLang(String path) {
        this.rows = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line;
            while((line = br.readLine()) != null)
                this.rows.add(line);
            br.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void addOrCreate(LinkedHashMap<String, LinkedHashSet<String>> programmersMap, String key, String value) {
        LinkedHashSet<String> element = programmersMap.computeIfAbsent(key, k -> new LinkedHashSet<>());
        element.add(value);
    }

    public LinkedHashMap<String, LinkedHashSet<String>> getLangsMap() {
        LinkedHashMap<String, LinkedHashSet<String>> langsMap = new LinkedHashMap<>();

        for (String line : this.rows) {
            String[] splittedLine = line.split("\t");
            String lang = "";

            for (int i = 0; i < splittedLine.length; i++) {
                String element = splittedLine[i];

                if (i == 0) {
                    lang = element;
                    continue;
                }
                this.addOrCreate(langsMap, lang, element);
            }
        }
        return langsMap;
    }

    public LinkedHashMap<String, LinkedHashSet<String>> getProgsMap() {
        LinkedHashMap<String, LinkedHashSet<String>> programmersMap = new LinkedHashMap<>();

        for (String line : this.rows) {
            String[] splittedLine = line.split("\t");
            String lang = "";

            for (int i = 0; i < splittedLine.length; i++) {
                String element = splittedLine[i];

                if (i == 0) {
                    lang = element;
                    continue;
                }
                this.addOrCreate(programmersMap, element, lang);
            }
        }
        return programmersMap;
    }

    public Map<String, LinkedHashSet<String>> getLangsMapSortedByNumOfProgs() {
        return this.sorted(
                this.getLangsMap(),
                (one, two) -> {
                    if (two.getValue().size() - one.getValue().size() == 0)
                        return one.getKey().compareTo(two.getKey());
                    return two.getValue().size() - one.getValue().size();
                }
        );
    }

    public Map<String, LinkedHashSet<String>> getProgsMapSortedByNumOfLangs() {
        return this.sorted(
                this.getProgsMap(),
                (one, two) -> {
                    if (two.getValue().size() - one.getValue().size() == 0)
                        return one.getKey().compareTo(two.getKey());
                    return two.getValue().size() - one.getValue().size();
                }
        );
    }

    public Map<String, LinkedHashSet<String>> getProgsMapForNumOfLangsGreaterThan(int i) {
        return this.filtered(this.getProgsMap(), (value) -> value.getValue().size() > i);
    }

    public <T, U> Map<T, U> filtered(Map<T, U> map, Predicate<Map.Entry<T, U>> predicate) {
        return map
                .entrySet()
                .stream()
                .filter(predicate)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new
                ));
    }

    public <T, U> Map<T, U> sorted(Map<T, U> map, Comparator<Map.Entry<T, U>> comparator) {
        return map
                .entrySet()
                .stream()
                .sorted(comparator)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new
                ));
    }
}