package converter

object RomanToArabic {

  def repeatRule(current: Int, repeat: Int) : Int = {
    if(List(5, 50, 500).contains(current)){
      return 4
    }else{
      return repeat + 1
    }
  }

  def subtractRule(previous_roman: Char, current_roman: Char) : Int = {
    val roman_list = roman_to_arabic.keys.toList
    val previous_roman_index = roman_list.indexOf(previous_roman)
    val roman_index = roman_list.indexOf(current_roman)
    if ((previous_roman_index - roman_index) > 1){
      return 4
    }else{
      return 1
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
        repeat = subtractRule(previous_roman, i)
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

object ArabicToRoman{
  val arabic_to_roman = Map(1 -> 'I', 5 -> 'V', 10 -> 'X', 50 -> 'L', 100 -> 'C', 500 -> 'D', 1000 -> 'M')

  def build_roman(arabic: Int) : String = {
    val below_arabic = arabic_to_roman.keys.filter(x => x <= arabic).max
    val remainder = arabic - below_arabic
    val current_roman = arabic_to_roman(below_arabic).toString
    if (remainder == 0){
      return current_roman
    }else{
      return current_roman.concat(build_roman(remainder))
    }
  }

  def apply(arabic:Int): String = {
    return build_roman(arabic)
  }
}
