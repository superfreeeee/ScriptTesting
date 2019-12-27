const p = console.log
const div = () => {
  p('\n-----new scope-----\n')
}

function* fibonacci() {
  let [prev, curr] = [0, 1]
  while (true) {
    ;[prev, curr] = [curr, prev + curr]
    yield curr
  }
}

i = 0
for (let n of fibonacci()) {
  p(`f(${++i}) = ${n}`)
  if (n > 1000) {
    break
  }
}

div()

function* objectEntries() {
  const keys = Object.keys(this)
  for (let key of keys) {
    yield [key, this[key]]
  }
}
const obj = { name: 'superfree', age: 20, education: 'university' }
obj[Symbol.iterator] = objectEntries

for (let [key, value] of obj) {
  p(`key=${key}, value=${value}, type=${typeof value}`)
}
