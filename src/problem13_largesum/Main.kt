package problem13_largesum

import utils.StringMathUtils
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
      result = StringMathUtils.add(result, numbers[i])
    }
    return result.substring(0, firstNumbers)
  }

  private fun getNumbersList() = File("""src/problem13_largesum/numbers.txt""").useLines { it.toList() }
}