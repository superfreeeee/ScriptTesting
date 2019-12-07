const p = console.log
const division = () => {
    p('\n-----new scope-----\n')
}

p('\u0061')
p('\uD842\uDFB7')
p('\u20BB7')
p('\u{20BB7}')
p('\u{41}\u{42}\u{43}')
p('\u{1F680}' === '\uD83D\uDE80')

division()

p('\z' === 'z')  // true
p('\172' === 'z') // true
p('\x7A' === 'z') // true
p('\u007A' === 'z') // true
p('\u{7A}' === 'z') // true

division()

for(let c of 'hello world') {
    p(c)
}
