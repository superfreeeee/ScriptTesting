const p = console.log;
const div = () => {
  p("\n-----new scope-----\n");
};

let s = new Set();

s.add(1)
  .add(2)
  .add(2);
p(s);
p(s.size);

div()

p(s.has(1));
p(s.has(2));
p(s.has(3));

div()

p(s.delete(2));
p(s.delete(3));

div()

p(s.has(1));
p(s.has(2));
p(s.has(3));

