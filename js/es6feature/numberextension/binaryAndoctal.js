const p = console.log
const division = () => {
    p('\n-----new scope-----\n')
}

// binary starts with 0b
p(0b01010 === 10)
// octal starts with 0o
p(0o0110 === 72)

division()

p(0b1010)
const num1 = Number('0b1010')
p(typeof num1)
p(num1)

