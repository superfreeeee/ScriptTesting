console.log('---es6 assignment test: number and boolean---\n')
const p = console.log
const division = () => {
    p('\n-----new scope-----\n')
}

let {length: len} = 'string'
p(len)

let {toString: numToString} = 123
p(numToString === Number.prototype.toString)

