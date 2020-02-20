package multiplesof3and5

/**
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
 * Find the sum of all the multiples of 3 or 5 below 1000.
 */
object Main {

  @JvmStatic
  fun main(args: Array<String>) {
    println(solution(1000))
  }

  private fun solution(n: Int): Int {
    if (n < 3) return 0
    var result = 0
    for (i in 3 until n) {
      if (i.rem(3) == 0 || i.rem(5) == 0) {
        result += i
      }
    }
    return result
  }
}