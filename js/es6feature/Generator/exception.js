const p = console.log
const div = () => {
  p('\n-----new scope-----\n')
}

function* test() {
  try {
    yield
  } catch (e) {
    p('catch inside')
    p(e)
  }
  yield p('after try catch')
}
let t = test()
t.next()
try {
  t.throw('throw 1')
  t.throw('throw 2')
  t.throw('throw 3')
} catch (e) {
  p('catch outside')
  p(e)
}
