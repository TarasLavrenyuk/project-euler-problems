package problem9_specialpythagoreantriplet

import kotlin.math.sqrt

/**
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which, aˆ2 + bˆ2 = cˆ2
 * For example, 3ˆ2 + 4ˆ2 = 9 + 16 = 25 = 5ˆ2.
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 * Find the product abc.
 */
object Main {

  @JvmStatic
  fun main(args: Array<String>) {
    println(solution())
  }

  private fun solution(): Int {
    for (x in 1 until 333) {
      for (y in x + 1 until 500) {
        val z = sqrt((x * x + y * y).toDouble())
        if (z.isWholeNumber() && x + y + z.toInt() == 1000) {
          return x * y * z.toInt()
        } else {
          continue
        }
      }
    }
    throw Exception("No solution :(")
  }

  private fun Double.isWholeNumber(): Boolean {
    return this / toInt() == 1.0
  }
}