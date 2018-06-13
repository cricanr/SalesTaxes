package example

class TaxCalculator {
  def getTotalTaxes(inputLines: Seq[String]): Double = {
    inputLines.map(inputLine => getTotalTax(inputLine)).sum
  }

  def getTotalTax(input: String): Double = {
    Math.round(getImportTax(input).getOrElse(0.0D) + getSalesTax(input).getOrElse(0.0D))
  }

  def getImportTax(input: String): Option[Double] = {
    if (input.toLowerCase.contains("imported")) {
      val maybeProduct = Product(input)
      maybeProduct.map(product => Math.round(product.price * 5 / 100 * 20.0).toDouble / 20.0)
    } else None
  }

  def getSalesTaxes(inputLines: Seq[String]): Double = {
    val taxCalculator = new TaxCalculator
    inputLines.map(inputLine => taxCalculator.getSalesTax(inputLine).getOrElse(0D)).sum
  }

  def getSalesTax(input: String): Option[Double] = {
    val maybeProduct = Product(input)
    maybeProduct.collect { case product if product.hasSalesTax => Math.round(product.price * 10 / 100 * 20.0).toDouble / 20.0 }
  }
}
