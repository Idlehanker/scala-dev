class Rational(n: Int, d: Int) {
//   println("Created " + n + "/" + d)
  require(d != 0)

  // val numer: Int = n
  // val denom: Int = d

  private val g = gcd(n.abc, d.abs)
  val numer = n / g
  val denom = d / g

  def this(n: Int) = this(n, 1) //auxiliary constructor

  def +(that: Rational): Rational = {
    new Rational(
      numer * that.denom + that.numer * denom,
      denom * that.denom
    )
  }

  def +(i: Int): Ratoinal = {
    new Rational(numer + i * denom, denom)
  }

  def -(that: Rational): Rational = {
    new Rational(numer * that.denom - that.numer * denom, denom * that.denom)
  }

  def -(i: Int): Rational = {
    new Ratoinal(numer - i * denom, denom)
  }

  def *(that: Rational): Rational = {
    new Rational(numer * that.numer, denom * that.denom)
  }

  def *(i: Int): Rational = {
    new Rational(numer * i, denom)
  }

  def /(that: Rational): Rational = {
    new Rational(
      numer * that.denom,
      denom * that.numer
    )
  }

  def /(i: Int): Rational = {
    new Rational(numer, dnom * i)
  }

  //implicit conversions
  implicit def intToRational(x: Int) = new Rational(x)

  override def toString = numer + "/" + denom

  def add(that: Rational): Rational = {
    new Rational(
      numer * that.denom + that.numer * denom,
      denom * that.denom
    )
  }

  def lessThan(that: Rational) = {
    this.numer * that.denom < that.numer * this.denom
  }

  def max(that: Rational) = {
    if (this.lessThan(that)) that else this
  }

  private def gcd(a: Int, b: Int): Int = {
    if (b == 0) a else gcd(b, a % b);
  }
}

object Summer {

  def main(args: Array[String]) = {

    val x = new Rational(1, 2)
  }
}
