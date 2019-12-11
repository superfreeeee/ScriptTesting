const p = console.log;
const division = () => {
  p("\n-----new scope-----\n");
};

let arrayLike = {
  "0": "a",
  "1": "b",
  "2": "c",
  length: 3
};

let arr2 = Array.from(arrayLike); // ['a', 'b', 'c']
p(arr2);
p(Array.from("hello"));
p(Array.from(new Set([1, 2, 3, 2, 1])));

division();

p(Array.from({ 0: 1, 1: 2, 2: 3, 3: 4, length: 4 }, x => x * x));
p(Array.from([1, , 2, , 3], n => n || 0));
p(Array.from([null, , NaN], value => typeof value));
p(Array.from({ length: 10 }, () => 0));

division();

p(Array.of(1, 2, null, undefined, { 1: 1, 2: 2, 3: 3 }));

p(Array.of()); // []
p(Array.of(undefined)); // [undefined]
p(Array.of(1)); // [1]
p(Array.of(1, 2)); // [1, 2]

division();

// Array.copyWithin()
