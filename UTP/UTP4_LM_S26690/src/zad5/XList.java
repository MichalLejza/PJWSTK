package zad5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class XList<T> extends ArrayList<T>{

    public XList()
    {
        super();
    }

    public XList(T...args)
    {
        super(Arrays.asList(args));
    }

    public XList(Collection<T> c)
    {
        super(c);
    }

    public static<T> XList<T> of(T... args) {
        return new XList<T>(args);
    }

    public static<T> XList<T> of(Collection<T> c) {
        return new XList<T>(c);
    }

    public static <T> XList<T> charsOf(String string)
    {
        XList returnList  = new XList();
        for (int i = 0; i < string.length(); i++) {
            returnList.add(String.valueOf(string.charAt(i)));
        }
        return returnList;
    }

    public static XList<String> tokensOf(String str, String separator)
    {
        return new XList<>(str.split(separator));
    }
    public static XList<String> tokensOf(String str)
    {
        return new XList<>(str.split(" "));
    }

    public XList<T> union(T... args) {
        XList<T> returnList = new XList<>(this);
        returnList.addAll(Arrays.asList(args));
        return returnList;
    }

    public XList<T> union(Collection<T> c) {
        XList<T> returnList = new XList<>(this);
        returnList.addAll(c);
        return returnList;
    }

    public XList<T> diff(Collection<T> c) {
        XList<T> returnList = new XList<>(this);
        for (T t : c)
            returnList.remove(t);
        return returnList;
    }

    public XList<T> unique()
    {
        XList<T> returnList = new XList<>(this.stream().distinct().collect(Collectors.toList()));
        return returnList;
    }

    public XList<T> combine() {
        XList<T> returnList = new XList<>();
        T comb;
        for (int i = 0; i < this.size(); i++) {
            for (int j = 0; j < this.size(); j++) {
                comb = (T) ((this.get(i).toString()) + (this.get(j).toString()));
                returnList.add(comb);
            }
        }
        return returnList;
    }


    public <R> XList<R> collect(Function<T, R> f) {
        XList<R> returnList = new XList<>();
        for (R r : returnList) {
            returnList.add(f.apply((T) r));
        }
        return returnList;
    }

    public String join(String string) {
        StringBuilder sB = new StringBuilder();
        for (T t : this) {
            sB.append(t.toString() + string);
        }
        return sB.toString();
    }

    public String join() {
        StringBuilder sB = new StringBuilder();
        for (T t : this) {
            sB.append(t.toString() + " ");
        }
        return sB.toString();
    }

    public void forEachWithIndex(BiConsumer<T,Integer> c) {
        for (int i = 0; i < this.size(); i++) {
            c.accept(this.get(i), i);
        }
    }
}