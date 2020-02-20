package sumsquaredifference

/**
 * The sum of the squares of the first ten natural numbers is: 12+22+...+102=385
 * The square of the sum of the first ten natural numbers is: (1+2+...+10)2=552=3025
 * Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025−385=2640.
 *
 * Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
 */
object Main {

  @JvmStatic
  fun main(args: Array<String>) {
    println(getSumSquareDifference((1..100).toList()))
  }

  private fun getSumSquareDifference(list: List<Int>): Int {
    var result = 0
    for (i in 0 until list.size - 1) {
      for (j in i + 1 until list.size) {
        result += list[i] * list[j] * 2
      }
    }
    return result
  }
}