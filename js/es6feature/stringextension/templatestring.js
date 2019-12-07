const p = console.log
const division = () => {
    p('\n-----new scope-----\n')
}

p(`12345678 '3456789' "123" 09876ghjk ---\n\t\b 12342313`)
const s = `   123
line1
            line2
line3`
p('---' + s + '---')
p(`\`template string\``)

division()

function hi(name) {
    p(`hi ${name}`)
}
hi('superfree')
hi('john')

p('===' + '      12341231      '.trim() + '===')

division()

p(`${1} + ${2} = ${1+2}`)
function time() {
    const date = new Date
    return `${date.getFullYear()}.${date.getMonth() + 1}.${date.getDate()} ${date.getHours()}:${date.getMinutes()}:${date.getSeconds()}`
}
p(`It is ${time()} now`)
