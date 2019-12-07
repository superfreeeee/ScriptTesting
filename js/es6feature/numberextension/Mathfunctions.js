const p = console.log
const division = () => {
    p('\n-----new scope-----\n')
}

p(Math.trunc(4.1)) // 4
p(Math.trunc(4.9)) // 4
p(Math.trunc(-4.1))// -4
p(Math.trunc(-4.9))// -4
p(Math.trunc(-0.1234))// -0
p(Math.trunc('123.456'))
p()
p(Math.trunc(NaN))      // NaN
p(Math.trunc('foo'))    // NaN
p(Math.trunc())         // NaN

division()

p(Math.sign(-5)) // -1
p(Math.sign(5)) // +1
p(Math.sign(0)) // +0
p(Math.sign(-0)) // -0
p(Math.sign(NaN))// NaN
p(Math.sign('foo'))// NaN
p(Math.sign())// NaN

division()

p(Math.cbrt(-1)) // -1
p(Math.cbrt(0)) // 0
p(Math.cbrt(1)) // 1
p(Math.cbrt(2)) // 1.2599210498948734
p()
p(Math.cbrt('8')) // 2
p(Math.cbrt('hello')) // NaN

division()

p(Math.clz32(0))// 32
p(Math.clz32(1))// 31
p(Math.clz32(1000))// 22
p(Math.clz32(0b01000000000000000000000000000000)) // 1
p(Math.clz32(0b00100000000000000000000000000000)) // 2
p()
p(Math.clz32(0))// 32
p(Math.clz32(1))// 31
p(Math.clz32(1 << 1))// 30
p(Math.clz32(1 << 2))// 29
p(Math.clz32(1 << 29)) // 2
p()
p(Math.clz32(3.2)) // 30
p(Math.clz32(3.9)) // 30
p()
p(Math.clz32()) // 32
p(Math.clz32(NaN)) // 32
p(Math.clz32(Infinity)) // 32
p(Math.clz32(null)) // 32
p(Math.clz32('foo')) // 32
p(Math.clz32([])) // 32
p(Math.clz32({})) // 32
p(Math.clz32(true)) // 31

division()

p(Math.imul(2, 4)) // 8
p(Math.imul(-1, 8))// -8
p(Math.imul(-2, -2)) // 4

division()

Math.fround()
Math.hypot()

