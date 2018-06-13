package example

import org.scalatest.{Matchers, WordSpec}

class TaxCalculatorTest extends WordSpec with Matchers {
  "The Tax calculator getSalesTax method" when {
    "given the input '1 book at 12.49'" should {
      "return no sales tax" in {
        val taxCalculator = new TaxCalculator()
        taxCalculator.getSalesTax("1 book at 12.49") shouldEqual None
      }
    }

    "given the input '1 music CD at 14.99'" should {
      "return 1.50" in {
        val taxCalculator = new TaxCalculator()
        taxCalculator.getSalesTax("1 music CD at 14.99") shouldEqual Some(1.50)
      }
    }

    "given the input '1 chocolate bar at 0.85'" should {
      "return no sales tax" in {
        val taxCalculator = new TaxCalculator()
        taxCalculator.getSalesTax("1 chocolate bar at 0.85") shouldEqual None
      }
    }
  }
}
