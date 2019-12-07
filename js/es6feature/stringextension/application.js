const p = console.log
const division = () => {
    p('\n-----new scope-----\n')
}

// replace template string
const template = `
<div>
    My name is {{name}}
</div>
`

function compile(template) {
    const reg = /{{(.+?)}}/g
    let match
    while(match = reg.exec(template)) {
        const row = match[0]
        const key = match[1].trim()
        template = template.replace(row, data[key])
    }
    return template
}

const data = {
    name: 'superfree'
}
const result = compile(template)
p(result)

division()

// filter html string
const sender = '<script>alert("abc")</script>'; // 恶意代码
let message = SaferHTML`<p>${sender} has sent you a message.</p>`;
p(message)

function SaferHTML(templateData) {
    let s = templateData[0];
    for (let i = 1; i < arguments.length; i++) {
        let arg = String(arguments[i]);

        // Escape special characters in the substitution.
        s += arg.replace(/&/g, "&amp;")
                .replace(/</g, "&lt;")
                .replace(/>/g, "&gt;");

        // Don't escape special characters in the template.
        s += templateData[i];
    }
    return s;
}

// international language switch