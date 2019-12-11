const p = console.log;
const div = () => {
  p("\n-----new scope-----\n");
};

let foo = "bar";
let obj = { foo };
p(obj);

function f(x, y) {
  return { x, y };
}
obj = f(1, 2);
p(obj);

let x = 100;
obj = {
  x,
  hello() {
    p("hello world");
  },
  inc() {
    this.x++;
  }
};
p(obj);
obj.hello();
obj.inc();
p(obj);

div();

obj = {
  _id: 0,

  get id() {
    p("call get id");
    return this._id;
  },

  set id(id) {
    p("call set id: " + id);
    this._id = id;
  }
};
p(obj);
p(obj.id);
obj.id = 100;
p(obj.id);

div();

const key = "id";
obj = {
  ["_" + key]: 10,
  get [key]() {
    return this["_" + key];
  }
};
p(obj);
p(obj.id)
