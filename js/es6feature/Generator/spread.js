const p = console.log
const div = () => {
  p('\n-----new scope-----\n')
}

function* test() {
  yield 1
  yield 2
  return 3
  yield 4
}

p([...test()])
p(Array.from(test()))
let [x, y] = test()
p([x, y])
for (let i of test()) {
  p(i)
}
