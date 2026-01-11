package problem15_latticepaths

/**
 * Starting in the top left corner of a 2×2 grid, and only being able to move
 * to the right and down, there are exactly 6 routes to the bottom right corner.
 *
 * How many such routes are there through a 20×20 grid?
 */
object Main {

  @JvmStatic
  fun main(args: Array<String>) {
    println(getLatticePaths(20, 20))
  }

  private fun getLatticePaths(width: Int, height: Int): Long {
    return getBinomalCoeff(width + height, width)
  }

  private fun getBinomalCoeff(n: Int, k: Int): Long {
    val multipliers = getMultipliersForFactorial(n) - getMultipliersForFactorial(k)
    val dividers = getMultipliersForFactorial(n - k)

    simplify(multipliers, dividers).also {
      var result = 1L
      it.first.forEach { mult -> result *= mult }
      it.second.forEach { dev -> result /= dev }
      return result
    }
  }

  private fun simplify(multipliers: List<Int>, dividers: List<Int>): Pair<List<Int>, List<Int>> {
    val multipliersArray = multipliers.toTypedArray()
    val dividersArray = dividers.toTypedArray()

    for (dIndex in 0 until dividersArray.size) {
      for (mIndex in 0 until multipliersArray.size) {
        if (multipliersArray[mIndex].rem(dividersArray[dIndex]) == 0) {
          multipliersArray[mIndex] = multipliersArray[mIndex] / dividersArray[dIndex]
          dividersArray[dIndex] = 1
          break
        }
        if (dividersArray[dIndex].rem(multipliersArray[mIndex]) == 0) {
          dividersArray[dIndex] = dividersArray[dIndex] / multipliersArray[mIndex]
          multipliersArray[mIndex] = 1
        }
      }
    }
    return Pair(
        multipliersArray.filter { it != 1 }.toList(),
        dividersArray.filter { it != 1 }.toList()
    )
  }

  private fun getMultipliersForFactorial(n: Int): List<Int> {
    return (2..n).asSequence().map { it }.toList()
  }

  // not good for big numbers
  private fun getBinomalCoeffSlow(n: Int, k: Int): Long {
    if (k == 0 || k == n) {
      return 1L
    }
    return getBinomalCoeffSlow(n - 1, k - 1) + getBinomalCoeffSlow(n - 1, k)
  }

  // not good for big numbers (good approximately until 12X12)
  private fun getLatticePathsSlow(width: Int, height: Int): Long {
    if (width == 0 || height == 0) {
      return 1L
    }
    return getLatticePaths(width - 1, height) + getLatticePaths(width, height - 1)
  }
}