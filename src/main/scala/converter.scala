package converter

object RomanToArabic {

  val roman_to_arabic = Map("I" -> 1, "V" -> 5)
  def apply(roman: String) : Int = {
    return roman_to_arabic(roman)
  }

}
