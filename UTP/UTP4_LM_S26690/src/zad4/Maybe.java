package zad4;

import java.util.NoSuchElementException;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Maybe <T>
{
    T c;

    public Maybe(T c)
    {
        super();
        this.c = c;
    }

    public static <T> Maybe<T> of(T s)
    {
        return new Maybe<T>(s);
    }

    public void ifPresent(Consumer<T> cons)
    {
        if(c != null)
        {
            cons.accept(c);
        }
    }

    public boolean isPresent()
    {
        if(c != null){
            return true;
        }
        return false;
    }

    @Override
    public String toString()
    {
        if (c == null)
        {
            return "Maybe is empty ";
        }
        return "Maybe has value " + c.toString();
    }

    public T get()
    {
        if(c == null)
        {
            throw new NoSuchElementException("maybe is empty");
        }
        return c;
    }

    public <R> Maybe<R> map(Function<T, R> func)
    {
        if(c != null)
        {
            R x = func.apply(c);
            return new Maybe<R>(x);
        }
        return new Maybe<R>(null);
    }

    public T orElse (T defVal)
    {
        if(c == null)
        {
            return defVal;
        }
        return c;
    }

    public Maybe<T> filter(Predicate<T> pred)
    {
        if(c == null || pred.test(this.c))
        {
           return this;
        }
        return new Maybe<>(null);
    }


}
