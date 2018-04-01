trait Iterator[A] {
  def hasNext: Boolean

  def next(): A
}

class IntIterator(to: Int) extends Iterator[Int] {
  private var current = 0

  override def hasNext: Boolean = current < to

  override def next(): Int = {
    if (hasNext) {
      val t = current
      current += 1
      t
    } else 0
  }
}

val iterator = new IntIterator(10)
iterator.next()
iterator.next()


import javafx.scene.chart.PieChart.Data

import scala.collection.mutable.ArrayBuffer

trait Pet {
  val name: String
}

class Cat(val name: String) extends Pet

class Dog(val name: String) extends Pet

val dog = new Dog("Harry")
val cat = new Cat("Sally")

val animals = ArrayBuffer.empty[Pet]
animals.append(dog)
animals.append(cat)

animals.foreach(pet => println(pet.name))

///Mixin
abstract class A {
  val message: String
}

class B extends A {
  val message = "I'm an instance of class B"
}

trait C extends A {
  def loudMessage = message.toUpperCase()
}

class D extends B with C

val d = new D
println(d.message)
println(d.loudMessage)

//
abstract class AbsIterator {
  type T

  def hasNext: Boolean

  def next(): T
}

class StringIterator(s: String) extends AbsIterator {
  type T = Char
  private var i = 0

  def hasNext = i < s.length

  def next() = {
    val ch = s charAt i
    i += 1
    ch
  }
}

trait RichIterator extends AbsIterator {
  def foreach(f: T => Unit): Unit = while (hasNext) f(next())
}

/*
object StringIteratorTest extends App{
  class RichStringIter extends StringIterator("Scala") with RichIterator
  val richStringIter =  new RichStringIter
  richStringIter foreach println
}
*/
class RichStringIter extends StringIterator("Scala") with RichIterator
val richStringIter =  new RichStringIter
richStringIter foreach println