package converter

object RomanToArabic {

  def repeatRule(current: Int, repeat: Int) : Int = {
    if(List(5, 50, 500).contains(current)){
      return 4
    }else{
      return repeat + 1
    }
  }

  val roman_to_arabic = Map('I' -> 1, 'V' -> 5, 'X' -> 10, 'L' -> 50, 'C' -> 100, 'D' -> 500, 'M' -> 1000)
  def apply(roman: String) : Int = {
    val characters = roman.toList.reverse
    var total = 0
    var previous = 0
    var repeat = 1
    characters.foreach {i =>
      val current = roman_to_arabic(i)
      if (current < previous)
      {
        total = total - current
        repeat = 1
      }else if (current == previous) {
        repeat = repeatRule(current, repeat)
        total = total + current
      }else{
        repeat = 1
        total = total + current
      }
      previous = current
    }
    if (repeat > 3){return 0}
    return total
  }
}
