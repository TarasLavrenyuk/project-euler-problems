package problem13_largesum

import java.io.File

/**
 * Work out the first ten digits of the sum of the following one-hundred 50-digit numbers (file numbers.txt).
 */
object Main {

  @JvmStatic
  fun main(args: Array<String>) {
    println(getFirstNDigitsOfBigNumbersSum(getNumbersList(), 10))
  }

  private fun getFirstNDigitsOfBigNumbersSum(numbers: List<String>, firstNumbers: Int): String? {
    var result = numbers[0]
    for (i in 1 until numbers.size) {
      result = result.add(numbers[i])
    }
    return result.substring(0, firstNumbers)
  }

  private fun String.add(stringNumber: String): String {
    ensureStringsAreNumber(this, stringNumber)

    val length = if (length > stringNumber.length) length else stringNumber.length

    var result = ""
    var nextLevel = 0
    for (i in 1..length) {
      val addition = this.getNumberOnPosition(i) + stringNumber.getNumberOnPosition(i) + nextLevel
      result = addition.rem(10).toString() + result
      nextLevel = addition / 10
    }
    if (nextLevel != 0) {
      result = nextLevel.toString() + result
    }
    return result
  }

  private fun getNumbersList() = File("""src/problem13_largesum/numbers.txt""").useLines { it.toList() }

  private fun isNumberString(string: String): Boolean {
    for (i in 0 until string.length) {
      try {
        string[i].toString().toInt()
      } catch (e: NumberFormatException) {
        e.printStackTrace()
        return false
      }
    }
    return true
  }

  private fun ensureStringsAreNumber(vararg strings: String) = strings.forEach {
    if (!isNumberString(it)) {
      throw Exception(""""$it is not a number""")
    }
  }

  private fun String.getNumberOnPosition(position: Int): Int {
    return try {
      this[length - position].toString().toInt()
    } catch (e: IndexOutOfBoundsException) {
      0
    }
  }
}
