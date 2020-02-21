package problem3_largestprimefactor

import kotlin.math.sqrt

/**
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * What is the largest prime factor of the number 600851475143 ?
 */
object Main {

  @JvmStatic
  fun main(args: Array<String>) {
    println(getLPF(600851475143))
  }

  private fun getLPF(number: Long): Long {
    var lpf = -1L
    var copyOfNumber = number
    while (copyOfNumber.rem(2) == 0L) {
      copyOfNumber /= 2
    }

    for (i in 3..sqrt(copyOfNumber.toDouble()).toLong()) {
      while (copyOfNumber.rem(i) == 0L) {
        lpf = i
        copyOfNumber /= i
      }
    }
    if (copyOfNumber > lpf) {
      lpf = copyOfNumber
    }
    return lpf
  }
}