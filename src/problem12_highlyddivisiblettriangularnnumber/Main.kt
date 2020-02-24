package problem12_highlyddivisiblettriangularnnumber

import kotlin.math.sqrt

/**
 * The sequence of triangle numbers is generated by adding the natural numbers.
 * So the 7th triangle number would be 1 + 2 + 3 + 4 + 5 + 6 + 7 = 28.
 * The first ten terms would be: 1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...
 *
 * Let us list the factors of the first seven triangle numbers:
 *
 * 1: 1
 * 3: 1,3
 * 6: 1,2,3,6
 * 10: 1,2,5,10
 * 15: 1,3,5,15
 * 21: 1,3,7,21
 * 28: 1,2,4,7,14,28
 *
 * We can see that 28 is the first triangle number to have over five divisors.
 *
 * What is the value of the first triangle number to have over five hundred divisors?
 */
object Main {

  @JvmStatic
  fun main(args: Array<String>) {
    println(getNumberOfDivisors(16))
  }

  private fun getTriangleNumberWithOverDivisors(numberOfDivisors: Int): Int {
    var triangleNumber = 1
    var pluser = 1
    while (true) {
      if (getNumberOfDivisors(triangleNumber) > numberOfDivisors) {
        return triangleNumber
      }
      triangleNumber += (++pluser)
    }
  }

  private fun getNumberOfDivisors(num: Int): Int {
    if (num < 1) return 0
    if (num == 1) return 1
    if (num <= 3) return 2

    var numberOfDivisors = 2
    val sqrt = sqrt(num.toDouble()).toInt()
    for (i in 2..sqrt) {
      if (num.rem(i) == 0) {
        numberOfDivisors += 2
      }
    }
    if (num.rem(sqrt) == 0) {
      numberOfDivisors--
    }
    return numberOfDivisors
  }
}