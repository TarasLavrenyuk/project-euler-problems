package problem16_powerdigitsum

import utils.StringMathUtils

/**
 * 2ˆ15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
 *
 * What is the sum of the digits of the number 21000?
 */
object Main {

  @JvmStatic
  fun main(args: Array<String>) {
    println(getSumOfNumbersInString(StringMathUtils.getPowerOf("2", 1000)))
  }

  private fun getSumOfNumbersInString(string: String): Int {
    var result = 0
    for (i in 0 until string.length) {
      result += string[i].toString().toInt()
    }
    return result
  }
}