println("Hello world!")

println({
  val x = 1 + 1
  x + 1
})

///function
val addOne = (x: Int) => x + 1
println(addOne(1))

//
val add = (x: Int, y: Int) => x + y
println(add(1, 2))


//val g
val getTheAnswer = () => 42
println(getTheAnswer())

///method
def add1(x: Int, y: Int): Int = x + y
println(add1(3, 2))

//
def addThenMulltipy(x: Int, y: Int)(multipier: Int): Int =
  (x + y) * multipier

println(addThenMulltipy(1, 2)(3))

//
def name: String = System.getProperty("user.name")
println("Hello, " + name + "!")

//The last expression in the body is the method’s return value. (Scala does have a return keyword, but it’s rarely used.)
def getSquareString(input: Double): String = {
  val square = input * input
  square.toString
}
println(getSquareString(11.2))

//class
class Greeter(prefix: String, suffix: String) {
  def greet(name: String): Unit = println(prefix + name + suffix)
}


val greeter = new Greeter("Hello, ", "!")
greeter.greet("Scala developer")

//case class
case class Point(x: Int, y: Int)

val point = Point(1, 2)
val anotherPoint = Point(1, 2)
val yetAnotherPoint = Point(2, 3)

if (point == anotherPoint) {
  println(point + " and " + anotherPoint + " are the same.")
} else {
  println(point + " and " + anotherPoint + " are different.")
}

if (point == yetAnotherPoint) {
  println(point + " and " + yetAnotherPoint + " are the same.")
} else {
  println(point + " and " + yetAnotherPoint + " are different.")
}


///Object
object IdFactory {
  private var counter = 0

  def create(): Int = {
    counter += 1
    counter
  }
}

val newId = IdFactory.create()
println(newId)

val newerId: Int = IdFactory.create()
println(newerId)

///Trait
trait Greeter1 {
  def greet(name: String): Unit = println("Hello, " + name + "!")
}

class DefaultGreeter extends Greeter1

class CustomizableGreeter(prefix: String, postfix: String) extends Greeter1 {
  override def greet(name: String): Unit = {
    println(prefix + name + postfix)
  }
}

val greet = new DefaultGreeter()
greet.greet("Scale developer")

val customGreeter = new CustomizableGreeter("How are you, ", "?")
customGreeter.greet("Scala developer")


object Main {
  def main(args: Array[String]): Unit =
    println("Hello, Scala developer!!!")
}


val list: List[Any] = List(
  "a string",
  732,
  'c',
  true,
  () => "An anonymous function returning a string"
)

list.foreach(ele => println(ele))