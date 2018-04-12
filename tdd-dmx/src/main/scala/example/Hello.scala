package example

object Hello extends Greeting with App {
  println(greeting)
}

trait Greeting {
  val greeting: String = "hello"
}
