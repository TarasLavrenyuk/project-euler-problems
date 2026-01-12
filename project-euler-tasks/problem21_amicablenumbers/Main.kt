package problem21_amicablenumbers

import kotlin.math.sqrt

/**
 * Let d(n) be defined as the sum of proper divisors of n (numbers less than n which divide evenly into n).
 * If d(a) = b and d(b) = a, where a ≠ b, then a and b are an amicable pair and each of a and b are called amicable numbers.
 *
 * For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; therefore d(220) = 284. The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.
 *
 * Evaluate the sum of all the amicable numbers under 10000.
 */
object Main {

  @JvmStatic
  fun main(args: Array<String>) {
    var result = 0
    val map = mutableMapOf<Int, Int>()
    for (i in 2..10000) {
      val value = getSumOfProperDivisors(i)
      map[value]?.let {
        if (it == i) {
          result += i + value
        }
      }
      map[i] = value
    }
    println(result)
  }

  private fun getSumOfProperDivisors(n: Int): Int {
    var result = 0
    getListOfStrictDivisors(n).forEach {
      result += it
    }
    return result
  }

  private fun getListOfStrictDivisors(N: Int): List<Int> {
    if (N <= 1) throw IllegalArgumentException()
    if (N <= 3) return listOf(1)
    val result = mutableListOf(1)
    for (i in 2..sqrt(N.toFloat()).toInt()) {
      if (N.rem(i) == 0) {
        result.add(i)
        if (N / i != i) {
          result.add(N.div(i))
        }
      }
    }
    return result
  }
}