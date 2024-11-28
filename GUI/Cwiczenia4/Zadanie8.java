package GUI.Cwiczenia4;


import java.util.Arrays;
import java.util.Locale;

@FunctionalInterface
interface Transform<T,R>
{
    R apply(T typ);
}

class StrToInt implements Transform<String, Integer>
{
    @Override
    public Integer apply(String typ) {
        return typ.length();
    }


}

public class Zadanie8
{
    private static <T,R>
    void transform(T[] in, R[] out, Transform<T,R> trans)
    {
        for(int i = 0; i < out.length; i++)
            out[i] = trans.apply(in[i]);
    }

    public static void main(String[] args) {

        String[] sin = {"Alice", "Sue", "Janet", "Bea"};
        System.out.println(Arrays.toString(sin) + '\n');

        Integer[] iout = new Integer[sin.length];
        transform(sin, iout, new StrToInt());
        System.out.println(Arrays.toString(iout));

        Character[] cout = new Character[sin.length];
        transform(sin, cout, (String tekst) -> tekst.charAt(0));
        System.out.println(Arrays.toString(cout));

        String[] sout = new String[sin.length];
        transform(sin, sout, (String tekst) -> tekst.toUpperCase());
        System.out.println(Arrays.toString(sout));

    }
}
