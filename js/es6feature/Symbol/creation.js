const p = console.log;
const div = () => {
  p("\n-----new scope-----\n");
};

let a = Symbol();
let b = Symbol();
let c = Symbol();
p(typeof a);
p(a === b);
p(a === c);
p(b === c);
p()
a = Symbol("a");
p(a);
p(typeof a);
p(a.toString());
p(typeof a.toString());
p(Boolean(a));
p(typeof Boolean(a));
p(!b)