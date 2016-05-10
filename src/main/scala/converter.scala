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
    var previous_roman = 'I'
    characters.foreach {i =>
      val current = roman_to_arabic(i)
      if (current < previous)
      {
        val previous_roman_index = roman_to_arabic.keys.toList.indexOf(previous_roman)
        val roman_index = roman_to_arabic.keys.toList.indexOf(i)
        if ((previous_roman_index - roman_index) > 1){
          repeat = 4
        }else{
          repeat = 1
        }
        total = total - current
      }else if (current == previous) {
        repeat = repeatRule(current, repeat)
        total = total + current
      }else{
        repeat = 1
        total = total + current
      }
      previous = current
      previous_roman = i
    }
    if (repeat > 3){return 0}
    return total
  }
}
