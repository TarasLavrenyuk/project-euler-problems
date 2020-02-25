package problem14_longestcollatzsequence

/**
 * The following iterative sequence is defined for the set of positive integers:
 *
 * n → n/2 (n is even)
 * n → 3n + 1 (n is odd)
 *
 * Using the rule above and starting with 13, we generate the following sequence:
 *
 * 13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
 *
 * It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.
 *
 * Which starting number, under one million, produces the longest chain?
 *
 * NOTE: Once the chain starts the terms are allowed to go above one million.
 */

object Main {

  private val numberOfStepsForNumber = hashMapOf<Long, Int>()

  @JvmStatic
  fun main(args: Array<String>) {
    var result = 0
    var maxSteps = 0
    for (i in 1..1000000) {
      getNumberOfCollatzStepsForNumber(i.toLong()).also {
        if (it > maxSteps) {
          result = i
          maxSteps = it
        }
      }
    }
    println("$maxSteps for $result")
  }

  private fun getNumberOfCollatzStepsForNumber(number: Long): Int {
    if (number < 1) {
      throw Exception("Parameter [number] should be gte 1!")
    }
    var numberCopy: Long = number
    var numberOfSteps = 0
    while (numberCopy != 1L) {
      numberOfStepsForNumber[numberCopy]?.let {
        val result = numberOfSteps + it
        numberOfStepsForNumber[number] = result
        return result
      }
      numberCopy = getNextCollatzNumber(numberCopy)
      numberOfSteps++
    }
    numberOfStepsForNumber[number] = numberOfSteps
    return numberOfSteps
  }

  private fun getNextCollatzNumber(number: Long): Long {
    return if (number.rem(2) == 0L) {
      number / 2
    } else {
      number * 3 + 1
    }
  }
}