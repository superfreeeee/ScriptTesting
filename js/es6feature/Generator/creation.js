const p = console.log
const div = () => {
  p('\n-----new scope-----\n')
}

function* test() {
  p('test init')
  yield 'hello'
  yield 'world'
  return 'end'
}

let t = test()
p(t.next())
p(t.next())
p(t.next())
p(t.next())

div()

function* test1() {
  for (let i = 0; true; i++) {
    const param = yield i
    if (param) {
      i = -1
    }
  }
}

t = test1()
p(t.next())
p(t.next())
p(t.next())
p(t.next())
p(t.next(true)) // true作為上次暫停後的返回值
p(t.next())
p(t.next())

div()

function* test2() {
  let total = 0
  while (true) {
    let n = yield total
    total += n
  }
}

;(t = test2()).next()
p(t.next(1))
p(t.next(2))
p(t.next(-1))

div()

function test2_2() {
  function* test2() {
    let total = 0
    while (true) {
      let n = yield total
      total += n
    }
  }
  const t = test2()
  t.next()
  return t
}
t = test2_2()
p(t.next(1))
p(t.next(2))
p(t.next(-1))
p(typeof t.next(-1))

div()

function* test3(n) {
  for(let i=0 ; i<n ; i++) {
    yield i
  }
}

for(let i of test3(10)) {
  p(i)
}
