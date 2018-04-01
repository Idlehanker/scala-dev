val salaries = Seq(20000, 70000, 40000)
val doubleSalary = (x: Int) => x * 2
val newSalaries = salaries.map(doubleSalary)
println(newSalaries)

//
val newSalaries1 = salaries.map(x => x * 3)
println(newSalaries1)

val newSalaries2 = salaries.map(_ * 4)
println(newSalaries2)

///coerce methods into functions
case class WeeklyWeatherForecase(temperature: Seq[Double]) {
  private def convertCtoF(temp: Double) = temp * 1.8 + 32

  def forecastInFahrenheit: Seq[Double] = temperature.map(convertCtoF)
}

val tempture = WeeklyWeatherForecase(Seq(24.3, 34.1))
println(tempture.forecastInFahrenheit)


///functions that accept functions
object SalaryRaiser {
  private def promotion(salaries: List[Double], promotionFunction: Double => Double): List[Double] =
    salaries.map(promotionFunction)

  def smallPromotion(salaries: List[Double]): List[Double] = promotion(salaries, salary => salary * 1.1)

  def bigPromotion(salaries: List[Double]): List[Double] = promotion(salaries, salary => salary * math.log(salary))

  def hugePromotion(salaries: List[Double]): List[Double] = promotion(salaries, salary => salary * salary)

}

//val salaryRaiser = new SalaryRaiser
val doubleSalaries = List(12221.0, 22000.3, 299033.9)
println("small promotion: " + SalaryRaiser.smallPromotion(doubleSalaries))
println("big promotion: " + SalaryRaiser.bigPromotion(doubleSalaries))
println("huge promotion: " + SalaryRaiser.hugePromotion(doubleSalaries))


///Function that return functions
def urlBuider(ssl: Boolean, domainName: String): (String, String) => String = {
  val schema = if (ssl) "https://" else "http://"
  (endPoint: String, query: String) => s"$schema$domainName/$endPoint?$query"
}

val domainName = "www.exmaple.com"
def getUrl = urlBuider(ssl = true, domainName)
val endPoint = "users"
val query = "id=10"
val url = getUrl(endPoint, query)
println(url)

//nested method
def factorial(x: Int): Long = {

  def fact(x: Int, accumulator: Int): Long = {
    if (x <= 1) accumulator
    else fact(x - 1, x * accumulator)
  }

  fact(x, 1)
}

println("Factorial of 2: " + factorial(2))
println("Factorial of 10: " + factorial(13))
