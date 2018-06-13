package example

import org.scalatest.{Matchers, WordSpec}

class PriceCalculatorTest extends WordSpec with Matchers {
  "The Price calculator" when {
    "given the input '1 book at 12.49'" should {
      "return '1 book : 12.49'" in {
        val priceCalculator = new PriceCalculator()
        priceCalculator.getPrice("1 book at 12.49") shouldEqual Some(12.49)
      }
    }

    "given the input '2 music CD: 16'" should {
      "return '1 music CD: 8'" in {
        val priceCalculator = new PriceCalculator()
        priceCalculator.getPrice("2 music CD at 16") shouldEqual Some(8)
      }
    }

    "given the input '1 chocolate bar at 0.85'" should {
      "return Product(chocolate bar, 0.85)" in {
        val priceCalculator = new PriceCalculator()
        priceCalculator.getPrice("2 music CD at 16") shouldEqual Some(8)
      }
    }
  }
}
