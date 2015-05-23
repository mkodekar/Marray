# Marray

**You should use Marray instead of ArrayList.**

You can use `map`, `filter`, `join` and etc.

This library is very small.

## Setup

```
dependencies {
    compile 'kgmyshin:marray:0.0.2'
}
```

## Usage

#### Constructor

List instance change Marray instance.

```
    Marray<String> marray1 = new Marray<>();
    Marray<String> marray2 = new Marray<>(Arrays.asList("first", "second", "third"));
```

#### map

```
    Marray<Integer> marray = new Marray<>(Arrays.asList(1, 2, 5));
    Marray<Integer> mapped = marray.map(new Marray.MapOpe<Integer, Integer>() {
        @Override
        public Integer func(Integer integer) {
            return integer * 2;
        }
    });
    // mapped => 2, 4, 10
```

#### filter

```
    Marray<Integer> marray = new Marray<>(Arrays.asList(15, 9, 15, 30, 2));

    Marray<Integer> filtered = marray.filter(new Marray.CondOpe<Integer>() {
        @Override
        public boolean cond(Integer integer) {
            return integer > 10;
        }
    });
    // filtered => 15, 15, 30
```

#### join

```
    Marray<Integer> marray = new Marray<>(Arrays.asList(15, 9, 15, 30, 2));

    Log.d("Log", marray.join(",")); // "15,9,15,30,2"
```

#### reduce

```
    Marray<Integer> marray = new Marray(Arrays.asList(1, 2, 3, 4, 5));

    int result = marray.reduce(new Marray.ReduceOpe<Integer>() {
        @Override
        public Integer func(Integer x, Integer y) {
            return x + y;
        }
    }); // 15

```

#### numbers

```
    Marray<Integer> marray = new Marray<>();
    for (int i = 0; i < 50; i++) {
        marray.add(i * 3);
    }

    marray.zero();      // 0
    marray.one();       // 3
    marray.two();       // 6
    marray.three();     // 9
    marray.four();      // 12
    marray.five();      // 15
    marray.fourtyTwo(); // 126
```

## Method Chain

You can use method chain.

```
    Marray<String> marray = new Marray<>(Arrays.asList("one", "two", "three", "four"));
    marray.map(new Marray.MapOpe<String, String>() {
        @Override
        public String func(String s) {
            return s + s;
        }
    }).filter(new Marray.CondOpe<String>() {
        @Override
        public boolean func(String s) {
            return s.length() > 7;
        }
    })
    .join(" "); // "threethree fourfour"
```

## Contributing

1. Fork it ( https://github.com/kgmyshin/Marray )
2. Create your feature branch (git checkout -b my-new-feature)
3. Commit your changes (git commit -am 'Add some feature')
4. Push to the branch (git push origin my-new-feature)
5. Create new Pull Request

## License

```
Copyright 2015 kgmyshin

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
