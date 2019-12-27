const p = console.log;
const div = () => {
  p("\n-----new scope-----\n");
}

const baz = Symbol.for('baz') 

class A {
  foo() {
    this[baz]()
  }
  
  // private method
  [baz]() {
    p('trigger baz')
  }
}

const a = new A()
a.foo()
