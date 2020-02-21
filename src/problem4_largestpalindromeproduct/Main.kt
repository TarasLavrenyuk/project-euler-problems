package problem4_largestpalindromeproduct

/**
 * A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
 * Find the largest palindrome made from the product of two 3-digit numbers.
 */
object Main {

  @JvmStatic
  fun main(args: Array<String>) {
    println(solution())
  }

  private fun solution(): Int {
    var result = -1
    for (i in 999 downTo 100) {
      for (j in 999 downTo 100) {
        val multiplicationResult = i * j
        if (multiplicationResult > result && multiplicationResult.isPalindromic())
          result = multiplicationResult
      }
    }
    return result
  }

  private fun Int.isPalindromic(): Boolean {
    val stringNumber = this.toString()
    for (i in 0..stringNumber.length / 2) {
      if (stringNumber[i] != stringNumber[stringNumber.length - 1 - i]) return false
    }
    return true
  }
}


