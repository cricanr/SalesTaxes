package example

class TaxCalculator {
  def getSalesTax(input: String): Option[Double] = {
    val maybeProduct = Product(input)
    maybeProduct.collect { case product if product.hasSalesTax => Math.round(product.price * 10 / 100 * 20.0).toDouble / 20.0 }
  }

}
