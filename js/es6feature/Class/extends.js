const p = console.log
const div = () => {
  p('\n-----new scope-----\n')
}

class Point {
  constructor(x, y) {
    this.x = x
    this.y = y
  }
}

class ColorPoint extends Point {
  constructor(x, y, color) {
    super(x, y)
    this.color = color
  }
}

const point = new Point(0, 0)
p(point)
const colorpoint = new ColorPoint(1, 1, 'blue')
p(colorpoint)

div()

p(colorpoint instanceof Point)
p(colorpoint instanceof ColorPoint)

div()

p(ColorPoint.__proto__ === Point)
p(ColorPoint.prototype.constructor === ColorPoint)
p(ColorPoint.prototype.__proto__ === Point.prototype)
p(ColorPoint.prototype.__proto__.constructor === Point)

div()

p(Object.getPrototypeOf(ColorPoint) === Point)