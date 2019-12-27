const p = console.log;
const div = () => {
  p("\n-----new scope-----\n");
}

function* test() {
  yield 1
  try {
    yield 2
    yield 3
  } finally {
    yield 4
    yield 5
  }
  yield 6
  yield 7
}

let t = test()
p(t.next())
p(t.next())
p(t.return())
p(t.next())
p(t.next())
p(t.return())
p(t.next())





