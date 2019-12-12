const p = console.log;
const div = () => {
  p("\n-----new scope-----\n");
};

p(Object.is("foo", "foo"));
p(Object.is({}, {}));

p(+0 === -0);
p(NaN === NaN);
p(Object.is(+0, -0));
p(Object.is(NaN, NaN));

div();

let obj1 = { a: 1 };
let obj2 = { b: 2 };
let obj3 = { c: 3 };
Object.assign(obj1, obj2, obj3);
p(obj1);

obj1.d = 100;
p(obj1);
Object.assign(obj1, { b: 200 });
p(obj1);

let obj6 = { ...obj1, ...obj2, ...obj3 };
p(obj6);
obj1.a = 10;
p(obj6);
p(obj1);

div();

obj1 = { a: 1, b: 2 };
obj2 = Object.assign({}, obj1);
p(obj1);
p(obj2);
obj1.a = 100;
p(obj1);
p(obj2);

div();

// extends this, in constructor
class Point {
  constructor(x, y) {
    this.a = 1;
    this.b = 2;
    Object.assign(this, { x, y });
  }
}
obj1 = new Point(1, 2);
p(obj1);

// add function in prototype
Object.assign(
  Point.prototype,
  {
    func1() {
      p("func1");
    }
  },
  {
    func2() {
      p("func2");
    }
  }
);
p(Point.prototype);

div();

const DEFAULTS = {
  logLevel: 0,
  outputFormat: "html"
};

function processContent(options) {
  options = Object.assign({}, DEFAULTS, options);
  p(options);
}

processContent({ logLevel: 100 });

div();

obj1 = { a: 0 };
p(Object.getOwnPropertyDescriptor(obj1, "a"));
p(Object.getOwnPropertyDescriptor(Object.prototype, 'toString').enumerable)
p(Object.prototype)