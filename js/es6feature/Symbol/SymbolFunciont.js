const p = console.log;
const div = () => {
  p("\n-----new scope-----\n");
};

let foo = Symbol.for("foo");
let foo2 = Symbol.for("foo");
p(foo === foo2);
p(Symbol.keyFor(foo));
p(Symbol.keyFor(foo2));
let foo3 = Symbol("foo");
p(Symbol.keyFor(foo3));
