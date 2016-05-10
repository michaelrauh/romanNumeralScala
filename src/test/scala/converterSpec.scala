import converter.RomanToArabic
import converter.ArabicToRoman
import org.scalatest._

class converterSpec extends FlatSpec with Matchers {

  val romanConverter = RomanToArabic
  val arabicConverter = ArabicToRoman

  "A Roman to Arabic Converter" should "convert I to 1" in {
    romanConverter("I") shouldBe 1
  }

  it should "convert V to 5" in {
    romanConverter("V") shouldBe 5
  }

  it should "convert X to 10" in {
    romanConverter("X") shouldBe 10
  }

  it should "convert L to 50" in {
    romanConverter("L") shouldBe 50
  }

  it should "convert C to 100" in {
    romanConverter("C") shouldBe 100
  }

  it should "convert D to 500" in {
    romanConverter("D") shouldBe 500
  }

  it should "convert M to 1000" in {
    romanConverter("M") shouldBe 1000
  }

  it should "convert II to 2" in {
    romanConverter("II") shouldBe 2
  }

  it should "convert IV to 4" in {
    romanConverter("IV") shouldBe 4
  }

  it should "refuse to convert IIII and return 0" in {
    romanConverter("IIII") shouldBe 0
  }

  it should "refuse to convert VV and return 0" in {
    romanConverter("VV") shouldBe 0
  }

  it should "refuse to convert IL and return 0" in {
    romanConverter("IL") shouldBe 0
  }

  it should "refuse to convert XXC and return 0" in {
    romanConverter("XXC") shouldBe 0
  }

  it should "convert MLXVI to 1066" in {
    romanConverter("MLXVI") shouldBe 1066
  }

  it should "convert MCMLXXXIX to 1989" in {
    romanConverter("MCMLXXXIX") shouldBe 1989
  }

  "An Arabic to Roman converter" should "convert 1 to I" in {
    arabicConverter(1) shouldBe "I"
  }

  it should "convert 5 to V" in {
    arabicConverter(5) shouldBe "V"
  }

  it should "convert 10 to X" in {
    arabicConverter(10) shouldBe "X"
  }

  it should "convert 50 to L" in {
    arabicConverter(50) shouldBe "L"
  }

  it should "convert 100 to C" in {
    arabicConverter(100) shouldBe "C"
  }

  it should "convert 500 to D" in {
    arabicConverter(500) shouldBe "D"
  }

  it should "convert 1000 to M" in {
    arabicConverter(1000) shouldBe "M"
  }

  it should "convert 2 to II" in {
    arabicConverter(2) shouldBe "II"
  }

  it should "convert 4 to IV" in {
    arabicConverter(4) shouldBe "IV"
  }

  it should "convert 1989 to MCMLXXXIX" in {
    arabicConverter(1989) shouldBe "MCMLXXXIX"
  }
}
