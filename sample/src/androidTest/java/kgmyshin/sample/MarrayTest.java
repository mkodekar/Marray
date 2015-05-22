package kgmyshin.sample;

import org.junit.Test;

import java.util.Arrays;

import kgmyshin.marray.Marray;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class MarrayTest {

    @Test
    public void testList2Marray() {
        Marray<String> marray = Marray.list2Marray(Arrays.asList("A", "B", "C"));

        assertThat("A", is(marray.get(0)));
        assertThat("B", is(marray.get(1)));
        assertThat("C", is(marray.get(2)));
    }

    @Test
    public void testAny() {
        Marray<String> marray = Marray.list2Marray(Arrays.asList("ABC", "DDDD", "EEEEE"));

        boolean correct = marray.any(new Marray.Func<String, Boolean>() {
            @Override
            public Boolean func(String s) {
                return s.length() > 4;
            }
        });
        assertThat(true, is(correct));

        boolean wrong = marray.any(new Marray.Func<String, Boolean>() {
            @Override
            public Boolean func(String s) {
                return s.length() > 5;
            }
        });
        assertThat(false, is(wrong));
    }

    @Test
    public void testAll() {
        Marray<String> marray = Marray.list2Marray(Arrays.asList("ABC", "DDDD", "EEEEE"));

        boolean correct = marray.all(new Marray.Func<String, Boolean>() {
            @Override
            public Boolean func(String s) {
                return s.length() > 2;
            }
        });
        assertThat(true, is(correct));

        boolean wrong = marray.all(new Marray.Func<String, Boolean>() {
            @Override
            public Boolean func(String s) {
                return s.length() > 3;
            }
        });
        assertThat(false, is(wrong));
    }

    @Test
    public void testMap() {
        Marray<Integer> marray = Marray.list2Marray(Arrays.asList(1, 2, 5));

        Marray<Integer> mapped = marray.map(new Marray.Func<Integer, Integer>() {
            @Override
            public Integer func(Integer integer) {
                return integer * 2;
            }
        });

        assertThat(2, is(mapped.get(0)));
        assertThat(4, is(mapped.get(1)));
        assertThat(10, is(mapped.get(2)));
    }

    @Test
    public void testFilter() {
        Marray<Integer> marray = Marray.list2Marray(Arrays.asList(15, 9, 15, 30, 2));

        Marray<Integer> filtered = marray.filter(new Marray.Func<Integer, Boolean>() {
            @Override
            public Boolean func(Integer integer) {
                return integer > 10;
            }
        });

        assertThat(15, is(filtered.get(0)));
        assertThat(15, is(filtered.get(1)));
        assertThat(30, is(filtered.get(2)));
    }

    @Test
    public void testJoin() {
        Marray<Integer> marray = Marray.list2Marray(Arrays.asList(15, 9, 15, 30, 2));

        assertThat("15,9,15,30,2", is(marray.join(",")));
    }

}