console.log('---es6 assignment test: object---\n')

const p = console.log
const division = () => {
    p('\n-----new scope-----\n')
}

const ao1 = { a1: 1, a2: 2 }
p('ao1:', ao1)
let { a1, a2 } = ao1
p(a1)
p(a2)

const ao2 = { ...ao1, a5: 5, a4: 4, a3: 3 }
p('ao2:', ao2)
let { a3, a4 } = ao2
p(a3)
p(a4)

division()

const bo = { b1: 1, b2: 2, b3: 3, b4: 4, b5: 5, b6: 6, b7: 7 }
p('bo:', bo)
let { b1: b2, b3: b4 } = bo
// p(b1)
p(b2)
// p(b3)
p(b4)

let b5
let { b5: b6 } = bo
p(b5)
p(b6)

let b7
({ b7 } = { b8: 8, b7: 7 })
p(b7)

division()

const co = {
    ca1: [
        1, 2, 3
    ],
    ca2: [
        4, 5, 6
    ]
}
p('co', co)

let { ca2: c1, ca1: [c2, , c3] } = co
p(c1)
p(c2)
p(c3)

division()

const do1 = {
    x: 1,
    y: undefined,
    z: null
}
p('do1:', do1)

let { x: d1 = 4, y: d2 = 5, z: d3 = 6, w: d4 = 7 } = do1
p(d1)
p(d2)
p(d3)
p(d4)

const do2 = {
    x: {
        y: {
            z: 'string'
        }
    }
}
p('do2:', do2)
let {
    x: {
        y: {
            z: d5
        }
    }
} = do2
p(d5)

division()

const { sin, cos, log: ln, PI: pi, E } = Math
p(pi)
p(sin)
p(sin(pi / 2))
p(cos)
p(cos(pi))
p(ln)
p(E)
p(ln(E))

