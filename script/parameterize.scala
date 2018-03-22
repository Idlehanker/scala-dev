val greetStrings = new Array[String](3)
greetStrings(0) = "Hello"
greetStrings(1) = ", "
greetStrings(2) = "world!\n"

for(i <- 0 to 2) print(greetStrings(i))

val numNames = Array("zero", "one", "two")
for(i<- 0 to 2) println(numNames(i))

val pair = (99,"Luftballons")
println(pair._1)
println(pair._2)


println("--------set---------")
import scala.collection.immutable
var jetSet  = Set("Boeinig", "Airbus")
jetSet += "Lear"
println(jetSet.contains("Cessna"))


import scala.collection.mutable
var movieSet = mutable.Set("Hitch", "Poltergeist")
movieSet += "Shrek"
println(movieSet)

// def formatArgs(args:  Array[String]): Unit = {
//     args.foreach(println)
// }

def formatArgs(args: Array[String]) = args.mkString("\n")

val res = formatArgs(Array("zero", "one", "two"))
assert(res=="zero\none\ntwo")

