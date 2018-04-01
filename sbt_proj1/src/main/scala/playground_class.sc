class Point(var x: Int, var y: Int) {
  def move(dx: Int, dy: Int): Unit = {
    x = x + dx
    y = y + dy
  }

  override def toString: String = {
    s"($x,$y)"
  }
}

val point = new Point(2, 3)
println(point.x)
println(point)

point.move(1, 2)
println("After move(1,2)=" + point)

///class with default members
//Parameters without val or var are private values, visible only within the class.
class Point1(var x: Int = 0, var y: Int = 1) {

  def move(dx: Int, dy: Int): Unit = {
    x = x + dx
    y = y + dy
  }

  override def toString: String = {
    s"($x,$y)"
  }
}

val point1 = new Point1(x = 3)
println(point1)

///private members
class Point2 {
  private var _x = 0
  private var _y = 0
  private val bound = 100

  def x = _x

  def x_=(newValue: Int): Unit = {
    if (newValue < bound) _x = newValue else printWarning
  }

  def y = _y

  def y_=(newValue: Int): Unit = {
    if (newValue < bound) _y = newValue else printWarning
  }

  private def printWarning = println("WARNING: Out of bounds")
}

val point2 = new Point2
point2.x = 98
point2.y = 102
