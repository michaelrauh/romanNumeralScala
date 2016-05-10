import converter.RomanToArabic
import org.scalatest._

class converterSpec extends FlatSpec with Matchers {

  val romanConverter = RomanToArabic

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
}
