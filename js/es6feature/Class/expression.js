const p = console.log;
const div = () => {
  p("\n-----new scope-----\n");
}

const Person = class P {}
const person = new Person()
p(person)
// const person2 = new P()

p(person.name)
// p(P.name)
p(Person.name)