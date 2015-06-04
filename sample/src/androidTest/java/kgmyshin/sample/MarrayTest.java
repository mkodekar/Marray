package kgmyshin.sample;

import org.junit.Test;

import java.util.Arrays;

import kgmyshin.marray.Marray;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class MarrayTest {

    @Test
    public void testConstructor() {
        Marray<String> marray = new Marray(Arrays.asList("A", "B", "C"));

        assertThat(marray.get(0), is("A"));
        assertThat(marray.get(1), is("B"));
        assertThat(marray.get(2), is("C"));
    }

    @Test
    public void testAny() {
        Marray<String> marray = new Marray(Arrays.asList("ABC", "DDDD", "EEEEE"));

        boolean correct = marray.any(new Marray.CondOpe<String>() {
            @Override
            public boolean cond(String s) {
                return s.length() > 4;
            }
        });
        assertThat(correct, is(true));

        boolean wrong = marray.any(new Marray.CondOpe<String>() {
            @Override
            public boolean cond(String s) {
                return s.length() > 5;
            }
        });
        assertThat(wrong, is(false));
    }

    @Test
    public void testAll() {
        Marray<String> marray = new Marray(Arrays.asList("ABC", "DDDD", "EEEEE"));

        boolean correct = marray.all(new Marray.CondOpe<String>() {
            @Override
            public boolean cond(String s) {
                return s.length() > 2;
            }
        });
        assertThat(correct, is(true));

        boolean wrong = marray.all(new Marray.CondOpe<String>() {
            @Override
            public boolean cond(String s) {
                return s.length() > 3;
            }
        });
        assertThat(wrong, is(false));
    }

    @Test
    public void testMap() {
        Marray<Integer> marray = new Marray(Arrays.asList(1, 2, 5));

        Marray<Integer> mapped = marray.map(new Marray.MapOpe<Integer, Integer>() {
            @Override
            public Integer func(Integer integer) {
                return integer * 2;
            }
        });

        assertThat(mapped.get(0), is(2));
        assertThat(mapped.get(1), is(4));
        assertThat(mapped.get(2), is(10));
    }

    @Test
    public void testFilter() {
        Marray<Integer> marray = new Marray(Arrays.asList(15, 9, 15, 30, 2));

        Marray<Integer> filtered = marray.filter(new Marray.CondOpe<Integer>() {
            @Override
            public boolean cond(Integer integer) {
                return integer > 10;
            }
        });

        assertThat(filtered.get(0), is(15));
        assertThat(filtered.get(1), is(15));
        assertThat(filtered.get(2), is(30));
    }

    @Test
    public void testJoin() {
        Marray<Integer> marray = new Marray(Arrays.asList(15, 9, 15, 30, 2));

        assertThat(marray.join(","), is("15,9,15,30,2"));
    }

    @Test
    public void testReduce() {
        Marray<Integer> marray = new Marray(Arrays.asList(1, 2, 3, 4, 5));

        int result = marray.reduce(new Marray.ReduceOpe<Integer>() {
            @Override
            public Integer func(Integer x, Integer y) {
                return x + y;
            }
        });

        assertThat(result, is(15));
    }

    @Test
    public void testFoldl() {
        Marray<Integer> marray = new Marray(Arrays.asList(1, 2, 3, 4, 5));

        int result = marray.foldl(new Marray.FoldOpe<Integer>() {
            @Override
            public Integer func(Integer x, Integer y) {
                return x + y;
            }
        });

        assertThat(result, is(15));
    }

    @Test
    public void testFoldr() {
        Marray<Integer> marray = new Marray(Arrays.asList(1, 2, 3, 4, 5));

        int result = marray.foldr(new Marray.FoldOpe<Integer>() {
            @Override
            public Integer func(Integer x, Integer y) {
                return x + y;
            }
        });

        assertThat(result, is(15));
    }

    @Test
    public void testNumbers() {
        Marray<Integer> marray = new Marray<>();
        for (int i = 0; i < 50; i++) {
            marray.add(i * 3);
        }

        assertThat(0, is(marray.zero()));
        assertThat(3, is(marray.one()));
        assertThat(6, is(marray.two()));
        assertThat(9, is(marray.three()));
        assertThat(12, is(marray.four()));
        assertThat(15, is(marray.five()));
        assertThat(126, is(marray.fortyTwo()));
        assertThat(marray.zero(), is(0));
        assertThat(marray.one(), is(3));
        assertThat(marray.two(), is(6));
        assertThat(marray.three(), is(9));
        assertThat(marray.four(), is(12));
        assertThat(marray.five(), is(15));
        assertThat(marray.fortyTwo(), is(126));
    }

    @Test
    public void testHead() {
        Marray<Integer> marray = new Marray(Arrays.asList(1, 2, 3, 4, 5));

        assertThat(marray.head(), is(1));
    }

    @Test
    public void testLast() {
        Marray<Integer> marray = new Marray(Arrays.asList(1, 2, 3, 4, 5));

        assertThat(marray.last(), is(5));
    }

    @Test
    public void testReverse() {
        Marray<Integer> marray = new Marray(Arrays.asList(1, 2, 3, 4, 5));
        Marray<Integer> reversed = marray.reverse();

        assertThat(reversed.zero(), is(5));
        assertThat(reversed.one(), is(4));
        assertThat(reversed.two(), is(3));
        assertThat(reversed.three(), is(2));
        assertThat(reversed.four(), is(1));
    }

}