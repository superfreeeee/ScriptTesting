const p = console.log;
const div = () => {
  p("\n-----new scope-----\n");
};

let arr = [1, 2, 3, 4, 5, 3, 2, 4, 1, 2, 3, 4, 2, 5];
let s1 = new Set();
arr.map(x => s1.add(x));
p(s1);

s1 = null;
p(s1);
s1 = new Set(arr);
p(s1);
p([...s1]);
p(s1.size);

div();

s1 = new Set();
s1.add(NaN);
s1.add(NaN);
p(s1);
p(s1.size);

div();

s1 = new Set();
s1.add({});
s1.add({});
p(s1);
p(s1.size);
