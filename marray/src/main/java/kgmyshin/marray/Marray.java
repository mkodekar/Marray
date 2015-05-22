package kgmyshin.marray;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kgmyshin on 2015/05/23.
 */
public class Marray<T> extends ArrayList<T> {

    public static <T> Marray<T> list2Marray(List<T> array) {
        Marray<T> result = new Marray<>();
        for (T item : array) {
            result.add(item);
        }
        return result;
    }

    public boolean any(Func<T, Boolean> cond) {
        boolean result = false;
        for (T item : this) {
            if (cond.func(item)) {
                result = true;
                break;
            }
        }
        return result;
    }

    public boolean all(Func<T, Boolean> cond) {
        boolean result = true;
        for (T item : this) {
            if (!cond.func(item)) {
                result = false;
                break;
            }
        }
        return result;
    }

    public <U> Marray<U> map(Func<T, U> func) {
        Marray<U> result = new Marray<>();
        for (T item : this) {
            result.add(func.func(item));
        }
        return result;
    }

    public Marray<T> filter(Func<T, Boolean> cond) {
        Marray<T> result = new Marray<>();
        for (T item : this) {
            if (cond.func(item)) {
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

    public interface Func<T ,U> {
        U func(T t);
    }

}
