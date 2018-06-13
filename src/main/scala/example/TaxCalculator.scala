package example

class TaxCalculator {
  def getSalesTaxes(inputLines: Seq[String]): Double = {
    val taxCalculator = new TaxCalculator
    inputLines.map(inputLine => taxCalculator.getSalesTax(inputLine).getOrElse(0D)).sum
  }

  def getSalesTax(input: String): Option[Double] = {
    val maybeProduct = Product(input)
    maybeProduct.collect { case product if product.hasSalesTax => Math.round(product.price * 10 / 100 * 20.0).toDouble / 20.0 }
  }
}
