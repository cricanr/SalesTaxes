package example

import scala.util.Try

case class Product(name: String, price: Double)

object Product {
  def apply(input: String): Option[Product] = {
    val words = input.split(" ")
    val maybeQuantity = words.headOption.collect { case quantity if Try(quantity.toInt).toOption.nonEmpty => quantity.toInt }
    val maybeAtWordIndex = words.indexOf("at")
    val maybeProductName = Try(words.slice(1, maybeAtWordIndex).mkString(" ")).toOption
    val maybePrice = Try(words(maybeAtWordIndex + 1).toDouble).toOption

    for {
      productName <- maybeProductName
      quantity <- maybeQuantity
      price <- maybePrice
    } yield Product(productName, price / quantity)
  }
}