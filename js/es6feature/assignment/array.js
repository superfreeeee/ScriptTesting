console.log('---es6 assignment test: array---\n')

const p = console.log
const division = () => {
    p('\n-----new scope-----\n')
}

let [a, b, c] = [1, 2, 3]
p(a)
p(b)
p(c)

let [, , d] = [4, 5, 6]
p(d)

let [, e,] = [7, 8, 9]
p(e)

division()

let [f, ...g] = [1, 2, 3, 4, 5, 6]
p(f)
p(g)

let [h, i, j] = ['h']
p(h)
p(i)
p(j)

let [k, [[l, ...o], , m], ...n] = [1, [[2, 3, 8, 9], 4, 5], 6, 7]
p(k)
p(l)
p(m)
p(n)
p(o)

division()

let [c1 = 3, c2 = 's3', c3] = []
p(c1)
p(c2)
p(c3)

let [c4 = 4, c5 = 5] = [undefined, null]
p(c4)
p(c5)

division()

function d1Val() {
    return new Date().toString()
}

let [d1 = d1Val()] = []
p(d1)

let [d2 = 7, d3 = d2] = []
p(d2)
p(d3)

const do1 = { a: 2, b: 3 }
let [d4 = do1, d5 = d4] = []
p(d4)
p(d5)
do1.a = 7
p(d4)
p(d5)