console.log('---es6 assignment test: function---\n')
const p = console.log
const division = () => {
    p('\n-----new scope-----\n')
}

function add([x, y]) {
    return x + y
}
const r1 = add([1, 2, 4, 5])
p(r1)

const r2 = [[1, 2], [3, 4]].map(([x, y]) => (x + y))
p(r2)