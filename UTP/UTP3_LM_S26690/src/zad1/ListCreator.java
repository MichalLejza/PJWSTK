package zad1;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class ListCreator<T, V>
{
    private List<T> destinations;
    private ListCreator(List<T> destinations)
    {
        this.destinations = destinations;
    }

    static public <T, V>ListCreator <T, V> collectFrom(List<T> destinations)
    {
        return new ListCreator<>(destinations);
    }

    public ListCreator <T, V> when(Predicate<T> predicate)
    {
        List<T> filteredList = new ArrayList<>();
        for (T t : destinations)
            if (predicate.test(t))
                filteredList.add(t);
        this.destinations = filteredList;
        return this;
    }

    public List<T> mapEvery(Function<T, T> applyRate)
    {
        List<T> filteredList = new ArrayList<>();
        for (T t : destinations)
            filteredList.add(applyRate.apply(t));
        return filteredList;
    }

}
