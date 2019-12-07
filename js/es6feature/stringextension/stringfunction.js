const p = console.log
const division = () => {
    p('\n-----new scope-----\n')
}

const nums = '1234567890'
p(nums.includes('34'))
p(nums.startsWith('123'))
p(nums.startsWith('345',2))
p(nums.endsWith('890'))
p(nums.endsWith('456',6))

division()

p('12321 '.repeat(3))
p('123 '.repeat(0))
p('123 '.repeat(2.9))