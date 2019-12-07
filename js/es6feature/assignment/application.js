const p = console.log
const division = () => {
    p('\n-----new scope-----\n')
}

// swap
let x = 1, y = 0
p(x, y);
([x, y] = [y, x]);
p(x, y);

division()

// mutiple return
function ex1() {
    return [1, 2, 3]
}
let [a, b, c] = ex1()
p(a, b, c)

function ex2() {
    return {
        d: 1,
        e: 2
    }
}
let { d, e } = ex2()
p(d, e)

division()

// flexible function parameter
function f1([x, y, z]) {
    p(`[${x}, ${y}, ${z}]`)
}
f1([1, 2, 3])

function f2({ x, y, z }) {
    p(`{x: ${x}, y: ${y}, z: ${z}}`)
}
f2({ x: 3, y: 2, z: 1 })

division()

// pick data from json
const data = {
    id: 101,
    status: 'OK',
    data: [98, 100]
}
let { id, status, data: number } = data
p(id, status, number)

division()

// default parameter
const ajax = function (url, {
    async = true,
    beforeSend = function () { },
    cache = true,
    complete = function () { },
    crossDomain = false,
    global = true
}) {

}

division()

// traverse Map
let map = new Map()
map.set('key1', 'value1')
map.set('key2', 'value2')
p(map)
for(let entry of map) {
    p(entry)
}

for (let [key, value] of map) {
    p(`${key}: ${value}`)
}

for(let key in map) {
    p(key)
}

division()

// require
const {func1, func2} = require('module_name')

