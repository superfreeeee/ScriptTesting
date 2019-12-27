const p = console.log
const div = () => {
  p('\n-----new scope-----\n')
}

function Point(x, y) {
  this.x = x
  this.y = y
}

Point.prototype.toString = function() {
  return `(${this.x}, ${this.y})`
}
let p1 = new Point(0, 0)
p(p1.toString())

class Point2 {
  constructor(x, y) {
    this.x = x
    this.y = y
  }

  toString() {
    return `(${this.x}, ${this.y})`
  }
}
p1 = new Point2(0, 0)
p(p1.toString())

p(typeof Point2)
p(Point2 === Point2.prototype.constructor)

Object.assign(Point2.prototype, {
  toArray() {
    return [this.x, this.y]
  },
  toObject() {
    return {x: this.x, y: this.y}
  }
})

p(p1.toArray())
p(p1.toObject())
p(Object.keys(Point2.prototype))
p(Object.getOwnPropertyNames(Point2.prototype))