const p = console.log;
const div = () => {
  p("\n-----new scope-----\n");
};

let a = Symbol("a");

let obj1 = {};
obj1[a] = "symbol a";
p(obj1);

let obj2 = {
  [a]: "symbol a"
};
p(obj2);

let obj3 = {};
Object.defineProperty(obj3, a, { value: "symbol a",enumerable:true });
p(obj3);

div()

const COLOR = {
  GREEN: Symbol(),
  RED: Symbol()
}
function f(color) {
  switch(color) {
    case COLOR.GREEN:
      p('it\'s green')
      break;
    case COLOR.RED:
      p('it\'s red')
  }
}
f(COLOR.GREEN)
f(COLOR.RED)