const p = console.log
const div = () => {
  p('\n-----new scope-----\n')
}

class Logger {
  constructor() {
    this.printName = this.printName.bind(this)
  }

  printName(name = 'there') {
    this.print('hello ' + name)
  }

  print(text) {
    p(text)
  }
}

let logger = new Logger()
let { printName } = logger
printName()

div()

class Logger2 {
  constructor() {
    this.printName = (name = 'there') => {
      this.print('hello ' + name)
    }
  }

  print(text) {
    p(text)
  }
}

logger = new Logger2();
({ printName } = logger)
printName()
