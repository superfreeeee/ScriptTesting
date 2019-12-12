const p = console.log;
const div = () => {
  p("\n-----new scope-----\n");
};

// avoid magic string/number
const SIZE = {
  B: Symbol(),
  KB: Symbol(),
  MB: Symbol(),
  GB: Symbol()
};

const byte = 8;
const k = 1024;

const bits = {
  [SIZE.B]: byte,
  [SIZE.KB]: byte * k,
  [SIZE.MB]: byte * Math.pow(k, 2),
  [SIZE.GB]: byte * Math.pow(k, 3)
};
p(bits[SIZE.B]);
p(bits[SIZE.KB]);
p(bits[SIZE.MB]);
p(bits[SIZE.GB]);

div();

// traverse attr symbols in object
for (let key of Object.getOwnPropertySymbols(bits)) {
  p(key);
  p(bits[key]);
}

div();

const namespace = Symbol("module1");
function Point(x, y) {
  this.x = x;
  this.y = y;
}
if (!global[namespace]) {
  global[namespace] = new Point(0, 0);
}
module.exports = global[namespace];

p(global[namespace]);
