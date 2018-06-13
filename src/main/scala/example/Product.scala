package example

import scala.util.Try

case class Product(name: String, price: Double, hasSalesTax: Boolean)

object Product {
  def apply(input: String): Option[Product] = {
    val words = input.split(" ")
    val maybeQuantity = words.headOption.collect { case quantity if Try(quantity.toInt).toOption.nonEmpty => quantity.toInt }
    val maybeAtWordIndex = words.indexOf("at")
    val maybeProductName = Try(words.slice(1, maybeAtWordIndex).mkString(" ")).toOption
    val maybePrice = Try(words(maybeAtWordIndex + 1).toDouble).toOption

    val maybeHasSalesTax = maybeProductName.map(productName =>
      if (productName.toLowerCase.trim.contains("book")
        || productName.toLowerCase.trim.contains("pill")
        || productName.toLowerCase.trim.contains("chocolate"))
        false else true)

    for {
      productName <- maybeProductName
      quantity <- maybeQuantity
      price <- maybePrice
      hasSalesTax <- maybeHasSalesTax
    } yield Product(productName, price / quantity, hasSalesTax)
  }
}