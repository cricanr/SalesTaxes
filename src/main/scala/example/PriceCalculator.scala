package example

class PriceCalculator {
  def getPrice(input: String): Option[Double] = {
    Product(input).map(_.price)
  }
}
