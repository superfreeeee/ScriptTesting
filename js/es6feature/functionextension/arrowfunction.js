const p = console.log;
const div = () => {
  p("\n-----new scope-----\n");
};

let f = () => {
  p("trigger f");
};
f();

let f2 = n => {
  p(n * n);
};
f2(5);

let f3 = (x = 0, y = 0) => {
  p([x, y]);
};
f3();

let f4 = x => x * x;
p(f4(6));

let f5 = x => {
  return x * 10;
};
p(f5(10));

let f6 = (id = 0, name = "superfree") => ({ id, name });
p(f6());
p(f6(10, "alice"));

div();

let arr = new Array(10).fill(0).map((item, index) => index);
p(arr);
arr = arr.sort((x, y) => y - x);
p(arr)
