# Marray

**You should use Marray instead of ArrayList.**

You can use `map`, `filter`, `join` and etc.

This library is very small.

## Setup

```
dependencies {
    compile 'com.android.support:appcompat-v7:22.1.1'
}
```

## Usage

#### list2Marray

List instance change Marray instance.

```
    ArrayList<String> array = new ArrayList<>(Arrays.asList("first", "second", "third"));
    Marray<String> marray = Marray.list2Marray(array);
```

#### map

```
    Marray<Integer> marray = Marray.list2Marray(Arrays.asList(1, 2, 5));
    Marray<Integer> mapped = marray.map(new Marray.Func<Integer, Integer>() {
        @Override
        public Integer func(Integer integer) {
            return integer * 2;
        }
    });
    // mapped => 2, 4, 10
```

#### filter

```
    Marray<Integer> marray = Marray.list2Marray(Arrays.asList(15, 9, 15, 30, 2));

    Marray<Integer> filtered = marray.filter(new Marray.Func<Integer, Boolean>() {
        @Override
        public Boolean func(Integer integer) {
            return integer > 10;
        }
    });
    // filtered => 15, 15, 30
```

#### join

```
    Marray<Integer> marray = Marray.list2Marray(Arrays.asList(15, 9, 15, 30, 2));

    Log.d("Log", marray.join(",")); // "15,9,15,30,2"
```

## Method Chain

You can use method chain.

```
    Marray<String> marray = Marray.list2Marray(Arrays.asList("one", "two", "three", "four"));
    marray.map(new Marray.Func<String, String>() {
        @Override
        public String func(String s) {
            return s + s;
        }
    }).filter(new Marray.Func<String, Boolean>() {
        @Override
        public Boolean func(String s) {
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
