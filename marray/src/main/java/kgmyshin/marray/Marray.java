package kgmyshin.marray;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by kgmyshin on 2015/05/23.
 */
public class Marray<T> extends ArrayList<T> {

    public Marray() {
    }

    public Marray(int size) {
        super(size);
    }

    public Marray(Collection<? extends T> collection) {
        super(collection);
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

    public T foldl(FoldOpe<T> ope) {
        T result = head();
        for (int i = 1; i < size(); i++) {
            result = ope.func(result, get(i));
        }
        return result;
    }

    public T foldr(FoldOpe<T> ope) {
        T result = last();
        for (int i = size() - 2; i >= 0; i--) {
            result = ope.func(result, get(i));
        }
        return result;
    }

    public T reduce(ReduceOpe<T> ope) {
        T result = head();
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

    public T fortyTwo() {
        return get(42);
    }

    public T head() {
        return get(0);
    }

    public T last() {
        return get(size() - 1);
    }

    public Marray<T> reverse() {
        Marray<T> clone = new Marray<>(this);
        Collections.reverse(clone);
        return clone;
    }

    public Marray<T> shuffle() {
        Marray<T> clone = new Marray<>(this);
        Collections.shuffle(clone);
        return clone;
    }

    public interface MapOpe<T, U> {
        U func(T t);
    }

    public interface ReduceOpe<T> {
        T func(T x, T y);
    }

    public interface FoldOpe<T> {
        T func(T x, T y);
    }

    public interface CondOpe<T> {
        boolean cond(T t);
    }

}
