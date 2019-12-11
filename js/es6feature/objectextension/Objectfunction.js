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

div()

