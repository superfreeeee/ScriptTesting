const p = console.log;
const div = () => {
  p("\n-----new scope-----\n");
};

let s = new Set(["red", "green", "blue"]);
console.log("\nkeys:");
for (let key of s.keys()) {
  console.log(key);
}

console.log("\nvalues:");
for (let value of s.values()) {
  console.log(value);
}

console.log("\nentries:");
for (let item of s.entries()) {
  console.log(item);
}

div();

p(Set.prototype[Symbol.iterator] === Set.prototype.values);

p("\nfor iterator");
for (let value of s) {
  p(value);
}

p("\nforEach iterator");
s.forEach(x => p(x));

div()

