package converter

object RomanToArabic {

  val roman_to_arabic = Map('I' -> 1, 'V' -> 5, 'X' -> 10, 'L' -> 50, 'C' -> 100, 'D' -> 500, 'M' -> 1000)
  def apply(roman: String) : Int = {
    val characters = roman.toList.reverse
    var total = 0
    characters.foreach {i =>
      val current = roman_to_arabic(i)
      total = total + current
    }
    return total
  }

}
