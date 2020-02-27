package utils

object StringMathUtils {

  fun getPowerOf(number: String, power: Int): String {
    if (power == 0) return "1"
    if (power == 1) return number
    var result = number
    repeat(power - 1) {
      result = mult(result, number)
    }
    return result
  }

  fun add(number1: String, number2: String): String {
    ensureStringsAreNumber(number1, number2)

    val length = if (number1.length > number2.length) number1.length else number2.length

    var result = ""
    var nextLevel = 0
    for (i in 1..length) {
      val addition = number1.getNumberOnPosition(i) + number2.getNumberOnPosition(i) + nextLevel
      result = addition.rem(10).toString() + result
      nextLevel = addition / 10
    }
    if (nextLevel != 0) {
      result = nextLevel.toString() + result
    }
    return result
  }

  fun mult(number1: String, number2: String): String {
    ensureStringsAreNumber(number1, number2)
    val longNumber: String
    val shortNumber: String
    defineLongerAndShorterNumber(number1, number2).also {
      longNumber = it.first
      shortNumber = it.second
    }

    var result = "0"

    for (i in 1..shortNumber.length) {
      var current = ""
      for (j in 1 until i) {
        current += "0"
      }
      var nextLevel = 0
      for (j in 1..longNumber.length) {
        val multiplication = shortNumber.getNumberOnPosition(i) * longNumber.getNumberOnPosition(j) + nextLevel
        current = multiplication.rem(10).toString() + current
        nextLevel = multiplication / 10
      }
      if (nextLevel != 0) {
        current = nextLevel.toString() + current
      }
      result = add(result, current)
    }
    return result
  }

  fun String.isNumberString(): Boolean {
    for (i in 0 until this.length) {
      try {
        this[i].toString().toInt()
      } catch (e: NumberFormatException) {
        e.printStackTrace()
        return false
      }
    }
    return true
  }

  fun ensureStringsAreNumber(vararg strings: String) = strings.forEach {
    if (!it.isNumberString()) {
      throw Exception(""""$it is not a number""")
    }
  }

  fun String.getNumberOnPosition(position: Int): Int {
    return try {
      this[length - position].toString().toInt()
    } catch (e: IndexOutOfBoundsException) {
      0
    }
  }

  private fun defineLongerAndShorterNumber(
      number1: String,
      number2: String
  ) = if (number1.length > number2.length) Pair(number1, number2)
  else Pair(number2, number1)
}