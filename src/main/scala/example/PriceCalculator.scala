package example

class PriceCalculator {
  def getTotalPrice(inputLines: Seq[String]): Double = {
    val taxCalculator = new TaxCalculator
    val totalTaxes = taxCalculator.getTotalTaxes(inputLines)
    val products = inputLines.map(Product(_))
    val totalPriceWithoutTaxes = products.map(_.map(_.price).getOrElse(0D)).sum

    totalPriceWithoutTaxes + totalTaxes
  }

  def getPrice(input: String): Option[Double] = {
    Product(input).map(_.price)
  }
}
