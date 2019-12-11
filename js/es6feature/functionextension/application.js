const p = console.log;
const div = () => {
  p("\n-----new scope-----\n");
};

function throwMissing() {
  throw new Error("missing parameter");
}

// necessary parameter
function foo(x = throwMissing()) {
  p("trigger foo");
  return x;
}

try {
  foo();
} catch (error) {
  console.error(error);
}

div();

// unnecessary parameter
function boo(x = undefined) {
  p("trigger boo");
  return x;
}

try {
  boo();
} catch (error) {
  console.error(error);
}

div();
// spread application
const arr = [1, 3, 5];
const arr2 = [2, 4, 6];

const arr3 = [...arr, ...arr2];
p(arr3);

const arr4 = [...arr, ...arr2, ...arr3];
p(arr4);

div();

const arr5 = new Array(10).fill(0).map((item, index) => index);
p(arr5);
const [head, ...rest] = arr5;
p(head, rest);

div();

p([..."hello"]);
