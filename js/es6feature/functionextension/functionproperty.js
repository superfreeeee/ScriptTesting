const p = console.log;
const div = () => {
  p("\n-----new scope-----\n");
};

let f = function func1() {};
p(f.name);
let f2 = function() {};
p(f2.name);
