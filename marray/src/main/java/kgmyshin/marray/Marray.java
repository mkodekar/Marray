package kgmyshin.marray;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kgmyshin on 2015/05/23.
 */
public class Marray<T> extends ArrayList<T> {

    public Marray(){
    }

    public Marray(List<T> array) {
        this();
        for (T item : array) {
            add(item);
        }
    }

    public boolean any(CondOpe<T> condOpe) {
        boolean result = false;
        for (T item : this) {
            if (condOpe.cond(item)) {
                result = true;
                break;
            }
        }
        return result;
    }

    public boolean all(CondOpe<T> condOpe) {
        boolean result = true;
        for (T item : this) {
            if (!condOpe.cond(item)) {
                result = false;
                break;
            }
        }
        return result;
    }

    public <U> Marray<U> map(MapOpe<T, U> ope) {
        Marray<U> result = new Marray<>();
        for (T item : this) {
            result.add(ope.func(item));
        }
        return result;
    }

    public Marray<T> filter(CondOpe<T> condOpe) {
        Marray<T> result = new Marray<>();
        for (T item : this) {
            if (condOpe.cond(item)) {
                result.add(item);
            }
        }
        return result;
    }

    public String join(String separator) {
        StringBuffer sbf = new StringBuffer();
        int size = size();
        for (int i = 0; i < size; i++) {
            T item = get(i);
            sbf.append(item.toString());
            if (i != size - 1) {
                sbf.append(separator);
            }
        }
        return sbf.toString();
    }

    public T reduce(ReduceOpe<T> ope) {
        T result = zero();
        for (int i = 1; i < size(); i++) {
            result = ope.func(result, get(i));
        }
        return result;
    }

    public T zero() {
        return get(0);
    }

    public T one() {
        return get(1);
    }

    public T two() {
        return get(2);
    }

    public T three() {
        return get(3);
    }

    public T four() {
        return get(4);
    }

    public T five() {
        return get(5);
    }

    public T fourtyTwo() {
        return get(42);
    }

    public interface MapOpe<T, U> {
        U func(T t);
    }

    public interface ReduceOpe<T> {
        T func(T x, T y);
    }

    public interface CondOpe<T> {
        boolean cond(T t);
    }

}
