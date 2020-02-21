package problem10_summationofprimes

import kotlin.math.sqrt

/**
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 * Find the sum of all the primes below two million.
 */
object Main {

  @JvmStatic
  fun main(args: Array<String>) {
    println(getSumOfPrimeNumbersBelow(2000000))
  }

  private fun getSumOfPrimeNumbersBelow(upperLimit: Int): Long {
    if (upperLimit < 2) return 0
    var result = 0L

    for (i in 2L..upperLimit) {
      if (i.isPrimeNumber()) {
        result += i
      }
    }
    return result
  }

  private fun Long.isPrimeNumber(): Boolean {
    if (this <= 1) return false
    if (this <= 3) return true

    if (rem(2) == 0L || rem(3) == 0L) return false

    for (i in 5 until sqrt(toDouble()).toInt() + 1 step 6) {
      if (rem(i) == 0L || rem(i + 2) == 0L) return false
    }
    return true
  }
}