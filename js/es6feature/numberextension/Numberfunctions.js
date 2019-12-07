const p = console.log
const division = () => {
    p('\n-----new scope-----\n')
}

p(Number.isFinite(0.8)); // true
p(Number.isFinite(15)); // true

p(Number.isFinite(NaN)); // false
p(Number.isFinite(Infinity)); // false
p(Number.isFinite(-Infinity)); // false
p(Number.isFinite('foo')); // false
p(Number.isFinite('15')); // false
p(Number.isFinite(true)); // false

division()

p(Number.isNaN(NaN)) // true

p(Number.isNaN(15)) // false
p(Number.isNaN('15')) // false
p(Number.isNaN(true)) // false

p(Number.isNaN(9 / NaN)) // true
p(Number.isNaN('true' / 0));  //* true *//
p(Number.isNaN('true' / 'true')); // true

division()

p(Number.parseInt('12.34'))
p(Number.parseFloat('123.456h'))
p(Number.parseInt === parseInt)
p(Number.parseFloat === parseFloat)

division()

p(Number.isInteger(25)) // true
p(Number.isInteger(25.0)) // true
p(Number.isInteger(25.1)) // false
p(Number.isInteger("15")) // false
p(Number.isInteger(true)) // false

division()

const m = Math.pow(2, 53)
p(m)
p(m === m + 1)

division()

p(Number.isSafeInteger('a')) // false
p(Number.isSafeInteger(null)) // false
p(Number.isSafeInteger(NaN)) // false
p(Number.isSafeInteger(Infinity)) // false
p(Number.isSafeInteger(-Infinity)) // false
p()
p(Number.isSafeInteger(3)) // true
p(Number.isSafeInteger(1.2)) // false
p(Number.isSafeInteger(9007199254740990)) // true
p(Number.isSafeInteger(9007199254740992))// false
p()
p(Number.isSafeInteger(Number.MIN_SAFE_INTEGER - 1))// false
p(Number.isSafeInteger(Number.MIN_SAFE_INTEGER)) // true
p(Number.isSafeInteger(Number.MAX_SAFE_INTEGER)) // true
p(Number.isSafeInteger(Number.MAX_SAFE_INTEGER + 1)) // false
