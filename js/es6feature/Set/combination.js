const p = console.log
const div = () => {
  p('\n-----new scope-----\n')
}

let s1 = new Set([1, 2, 3, 4, 5])
let s2 = new Set([1, 3, 5, 7, 9])
p(s1)
p(s2)

let union = new Set([...s1, ...s2])
p(union)
let intersect = new Set([...s1].filter(x => s2.has(x)))
p(intersect)
let difference = new Set([...s1].filter(x => !s2.has(x)))
p(difference)
