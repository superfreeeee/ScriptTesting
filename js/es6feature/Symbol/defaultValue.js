const p = console.log;
const div = () => {
  p("\n-----new scope-----\n");
};

class A {
  [Symbol.hasInstance](foo) {
    return foo instanceof Array;
  }
}
p([1, 2, 3] instanceof new A());

div();

class Even {
  static [Symbol.hasInstance](num) {
    return Number(num) % 2 === 0;
  }
}
p(1 instanceof Even);
p(2 instanceof Even);
p(12345 instanceof Even);

div();

let arr1 = [3, 4];
let arr2 = [1, 2].concat(arr1, 5);
p(arr1);
p(arr2);
p(arr1[Symbol.isConcatSpreadable]);
arr1[Symbol.isConcatSpreadable] = false;

let arr3 = [1, 2].concat(arr1, 5);
p(arr3);

div()

Symbol.species
Symbol.match
Symbol.replace
Symbol.search
Symbol.split
Symbol.iterator
Symbol.toPrimitive
Symbol.toStringTag
Symbol.unscopables