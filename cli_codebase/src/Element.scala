/**
Java's four namespace are: fields, methods, types and packages
Scals's two namespace are:
values(fields, methods, packages, and singleton objects)
types(class and trait names)
  */
abstract class Element {
  def contents: Array[String]

  def height: Int = contents.length
  def width: Int = if (height == 0) 0 else contents(0).length

}

class ArrayElement(conts: Array[String]) extends Element {
  def contents: Array[String] = conts
}

class LineElement(s: String) extends ArrayElement(Array(s)) {
  override def width = s.length
  override def height = 1
}
