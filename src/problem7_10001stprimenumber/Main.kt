package problem7_10001stprimenumber

import kotlin.math.sqrt

/**
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
 * What is the 10 001st prime number?
 */
object Main {

  @JvmStatic
  fun main(args: Array<String>) {
    println(getPrimeNumber(10001))
  }

  private fun getPrimeNumber(n: Int): Long {
    if (n < 1) {
      throw Exception()
    }
    var counter = 0
    for (i in 2..Long.MAX_VALUE) {
      if (i.isPrimeNumber() && ++counter == n) {
        return i
      }
    }
    throw Exception()
  }

  private fun Long.isPrimeNumber(): Boolean {
    if (this <= 1L) {
      return false
    }
    if (this <= 3L) {
      return true
    }
    if (rem(2) == 0L || rem(3) == 0L) {
      return false
    }

    for (i in 5..sqrt(toDouble()).toLong() step 6) {
      if (rem(i) == 0L || rem(i + 2) == 0L) {
        return false
      }
    }
    return true
  }
}