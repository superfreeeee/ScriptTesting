const p = console.log;
const div = () => {
  p("\n-----new scope-----\n");
};

// default params
function func1(x = "", y = "world") {
  console.log(x, y);
}

func1();
func1("hello");

// default Class props
function Point(x = 0, y = 0) {
  this.x = x;
  this.y = y;
}
let point = new Point();
p(point);
point = new Point(1, 10);
p(point);
point = new Point(undefined, 10);
p(point);

function foo({ x, y = 5 } = { x: "x", y: "y" }) {
  p([x, y]);
}
foo();
foo({});
foo({ x: 2 });
foo({ x: 3, y: 4 });

div();

p(function(x, y, z) {}.length);
p(function(x = 1, y, z) {}.length);
p(function(x, y = 2, z) {}.length);
p(function(x, y = 2, z = 3) {}.length);
p(function(x, y, z = 5) {}.length);

div();

let x = 1;
function f2(x, y = x) {
  p([x, y]);
}
f2();
f2(2);
f2(3, 4);

function f3(y = x) {
  p(y);
}
f3();
f3(4);
