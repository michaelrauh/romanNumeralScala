import converter.RomanToArabic
import org.scalatest._

class converterSpec extends FlatSpec with Matchers {

  val romanConverter = RomanToArabic

  "A Roman to Arabic Converter" should "convert I to 1" in {
    romanConverter("I") shouldBe 1
  }
}
