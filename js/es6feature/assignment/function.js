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

division()

// x, y 缺省時默認為0
// 函數缺省時默認為空對象
function move({ x = 0, y = 0 } = {}) {
    return [x, y]
}

p(move({ x: 3, y: 8 }))
p(move({ x: 3 }))
p(move({}))
p(move())



