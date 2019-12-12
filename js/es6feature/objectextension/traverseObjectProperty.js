const p = console.log;
const div = () => {
  p("\n-----new scope-----\n");
};

let obj = {
  [Symbol()]: 0,
  b: 0,
  10: 0,
  2: 0,
  a: 0
};
let keys = [];
for (let key in obj) {
  keys.push(key);
}
p(keys);
p(Object.keys(obj));
p(Object.getOwnPropertyNames(obj));
p(Object.getOwnPropertySymbols(obj));
p(Reflect.ownKeys(obj));

div();

let obj1 = {
  f() {
    p("name: " + this.name);
  }
};
let obj2 = {
  name: "superfree"
};
p(obj2.__proto__);
obj2.__proto__ = obj1;
p(obj2.__proto__);
obj2.f();

obj2.__proto__ = {};
p(obj2.__proto__);

Object.setPrototypeOf(obj2, obj1);
p(Object.getPrototypeOf(obj2));
