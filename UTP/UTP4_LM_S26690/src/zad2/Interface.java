package zad2;


import java.io.IOException;
import java.util.function.Function;

public interface Interface<T,R> extends Function<T,R>
{
    R cast(T t) throws IOException;

    @Override
    default R apply(T t)
    {
        try {
            return cast(t);
        }
        catch (Exception e)
        {
            throw new RuntimeException(e.getMessage());
        }
    }
}
