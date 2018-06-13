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

  "The Tax calculator getSalesTaxes method" when {
    "given multiple input lines'" should {
      "return total sales taxes for those products" in {
        val taxCalculator = new TaxCalculator()
        taxCalculator.getSalesTaxes(Seq("1 book at 12.49", "1 music CD at 14.99", "1 chocolate bar at 0.85")) shouldEqual 1.50
      }
    }
  }

  "The Tax calculator getImportTax method" when {
    "given the input '1 imported box of chocolates at 10.00'" should {
      "return import tax 0.5" in {
        val taxCalculator = new TaxCalculator()
        taxCalculator.getImportTax("1 imported box of chocolates at 10.00") shouldEqual Some(0.5)
      }
    }
  }

  "The Tax calculator getTotalTax method" when {
    "given the input '1 imported bottle of perfume at 27.99'" should {
      "return total tax (sales and import) 4.0" in {
        val taxCalculator = new TaxCalculator()
        taxCalculator.getTotalTax("1 imported bottle of perfume at 27.99") shouldEqual 4.0
      }
    }
  }

  "The Tax calculator getTotalTaxes method" when {
    "given multiple input lines" should {
      "return total tax (sales and import)" in {
        val taxCalculator = new TaxCalculator()
        taxCalculator.getTotalTaxes(Seq("1 imported bottle of perfume at 27.99",
          "1 bottle of perfume at 18.99",
          "1 packet of headache pills at 9.75",
          "1 box of imported chocolates at 11.25")) shouldEqual 7.0
      }
    }
  }

  "The Tax calculator getSalesTaxes method" when {
    "given multiple input lines" should {
      "return total sales taxes" in {
        val taxCalculator = new TaxCalculator()
        taxCalculator.getTotalTaxes(Seq("1 imported bottle of perfume at 27.99",
          "1 bottle of perfume at 18.99",
          "1 packet of headache pills at 9.75",
          "1 box of imported chocolates at 11.25")) shouldEqual 6.70
      }
    }
  }
}
