package problem5_smallestmultiple

/**
 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 */
object Main {

  @JvmStatic
  fun main(args: Array<String>) {
    val numbers = (1..20).asSequence().toList()
    println(getLCM(numbers))
  }

  private fun getLCM(list: List<Int>): Int {
    var lcm = 1
    for (i in 0 until list.size) {
      lcm = getLCM(lcm, list[i])
    }
    return lcm
  }

  private fun getLCM(a: Int, b: Int): Int {
    var lcm = if (a > b) a else b
    while (true) {
      if (lcm.rem(a) == 0 && lcm.rem(b) == 0) {
        return lcm
      }
      lcm++
    }
  }
}