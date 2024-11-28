package zad2;


import java.util.function.Function;

public class InputConverter <T>
{
    private final T value;

    public InputConverter(T input)
    {
        this.value = input;
    }

    final public <S> S convertBy(Function... functions)
    {
        Object in = value;
        Object sol = null;

        for (Function func : functions)
        {
            sol = func.apply(in);
            in = sol;
        }
        return (S)sol;
    }
}
