package example

import org.scalatest.{Matchers, WordSpec}

class ProductTest extends WordSpec with Matchers {
  "A Product" when {
    "given the input '1 book at 12.49'" should {
      "return Product(book,12.49, false)'" in {
        Product("1 book at 12.49") shouldEqual Some(Product("book", 12.49, false))
      }
    }

    "given the input '1 chocolate bar at 0.85'" should {
      "return Product(chocolate bar,0.85, false)'" in {
        Product("1 chocolate bar at 0.85") shouldEqual Some(Product("chocolate bar", 0.85, false))
      }
    }

    "given the input '1 music CD at 14.99'" should {
      "return Product(music CD,14.99, true)'" in {
        Product("1 music CD at 14.99") shouldEqual Some(Product("music CD", 14.99, true))
      }
    }
  }
}
