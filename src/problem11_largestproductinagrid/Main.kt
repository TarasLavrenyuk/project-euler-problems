package problem11_largestproductinagrid

/**
 * In the 20×20 grid below [matrix], four numbers along a diagonal line have been marked in red.
 *
 * The product of these numbers is 26 × 63 × 78 × 14 = 1788696.
 * What is the greatest product of four adjacent numbers in the same direction (up, down, left, right, or diagonally) in the 20×20 grid?
 */
object Main {

  private val matrix = listOf(
      listOf(8, 2, 22, 97, 38, 15, 0, 40, 0, 75, 4, 5, 7, 78, 52, 12, 50, 77, 91, 8),
      listOf(49, 49, 99, 40, 17, 81, 18, 57, 60, 87, 17, 40, 98, 43, 69, 48, 4, 56, 62, 0),
      listOf(81, 49, 31, 73, 55, 79, 14, 29, 93, 71, 40, 67, 53, 88, 30, 3, 49, 13, 36, 65),
      listOf(52, 70, 95, 23, 4, 60, 11, 42, 69, 24, 68, 56, 1, 32, 56, 71, 37, 2, 36, 91),
      listOf(22, 31, 16, 71, 51, 67, 63, 89, 41, 92, 36, 54, 22, 40, 40, 28, 66, 33, 13, 80),
      listOf(24, 47, 32, 60, 99, 3, 45, 2, 44, 75, 33, 53, 78, 36, 84, 20, 35, 17, 12, 50),
      listOf(32, 98, 81, 28, 64, 23, 67, 10, 26, 38, 40, 67, 59, 54, 70, 66, 18, 38, 64, 70),
      listOf(67, 26, 20, 68, 2, 62, 12, 20, 95, 63, 94, 39, 63, 8, 40, 91, 66, 49, 94, 21),
      listOf(24, 55, 58, 5, 66, 73, 99, 26, 97, 17, 78, 78, 96, 83, 14, 88, 34, 89, 63, 72),
      listOf(21, 36, 23, 9, 75, 0, 76, 44, 20, 45, 35, 14, 0, 61, 33, 97, 34, 31, 33, 95),
      listOf(78, 17, 53, 28, 22, 75, 31, 67, 15, 94, 3, 80, 4, 62, 16, 14, 9, 53, 56, 92),
      listOf(16, 39, 5, 42, 96, 35, 31, 47, 55, 58, 88, 24, 0, 17, 54, 24, 36, 29, 85, 57),
      listOf(86, 56, 0, 48, 35, 71, 89, 7, 5, 44, 44, 37, 44, 60, 21, 58, 51, 54, 17, 58),
      listOf(19, 80, 81, 68, 5, 94, 47, 69, 28, 73, 92, 13, 86, 52, 17, 77, 4, 89, 55, 40),
      listOf(4, 52, 8, 83, 97, 35, 99, 16, 7, 97, 57, 32, 16, 26, 26, 79, 33, 27, 98, 66),
      listOf(88, 36, 68, 87, 57, 62, 20, 72, 3, 46, 33, 67, 46, 55, 12, 32, 63, 93, 53, 69),
      listOf(4, 42, 16, 73, 38, 25, 39, 11, 24, 94, 72, 18, 8, 46, 29, 32, 40, 62, 76, 36),
      listOf(20, 69, 36, 41, 72, 30, 23, 88, 34, 62, 99, 69, 82, 67, 59, 85, 74, 4, 36, 16),
      listOf(20, 73, 35, 29, 78, 31, 90, 1, 74, 31, 49, 71, 48, 86, 81, 16, 23, 57, 5, 54),
      listOf(1, 70, 54, 71, 83, 51, 54, 69, 16, 92, 33, 48, 61, 43, 52, 1, 89, 19, 67, 48)
  )

  @JvmStatic
  fun main(args: Array<String>) {
    println(getLargestProductInAGrid(matrix))
  }

  private fun getLargestProductInAGrid(matrix: List<List<Int>>, step: Int = 4): Int {
    if (!matrix.hasMatrixTheSameRowLengths()) {
      throw Exception("Fucking matrix has different row lengths.")
    }

    val rowsNumber = matrix.size
    val columnsNumber = matrix[0].size

    var result = 0

    for (currentRow in 0 until rowsNumber) {
      for (currentColumn in 0 until columnsNumber) {
        getRight(currentRow, currentColumn, matrix, step)?.let {
          if (it > result) result = it
        }
        getDown(currentRow, currentColumn, matrix, step)?.let {
          if (it > result) result = it
        }
        getRightDown(currentRow, currentColumn, matrix, step)?.let {
          if (it > result) result = it
        }
        getRightUp(currentRow, currentColumn, matrix, step)?.let {
          if (it > result) result = it
        }
      }
    }
    return result
  }

  private fun getRight(currentRow: Int, currentColumn: Int, matrix: List<List<Int>>, step: Int): Int? {
    if (step < 1) return null
    val rowLength = matrix[0].size
    if (currentColumn + step > rowLength) return null
    var result = matrix[currentRow][currentColumn]
    for (i in 1 until step) {
      result *= matrix[currentRow][currentColumn + i]
    }
    return result
  }

  private fun getDown(currentRow: Int, currentColumn: Int, matrix: List<List<Int>>, step: Int): Int? {
    if (step < 1) return null
    val columnLength = matrix.size
    if (currentRow + step > columnLength) return null
    var result = matrix[currentRow][currentColumn]
    for (i in 1 until step) {
      result *= matrix[currentRow + i][currentColumn]
    }
    return result
  }

  private fun getRightDown(currentRow: Int, currentColumn: Int, matrix: List<List<Int>>, step: Int): Int? {
    if (step < 1) return null
    val columnLength = matrix.size
    val rowLength = matrix[0].size
    if (currentRow + step > columnLength || currentColumn + step > rowLength) return null
    var result = matrix[currentRow][currentColumn]
    for (i in 1 until step) {
      result *= matrix[currentRow + i][currentColumn + i]
    }
    return result
  }

  private fun getRightUp(currentRow: Int, currentColumn: Int, matrix: List<List<Int>>, step: Int): Int? {
    if (step < 1) return null
    val rowLength = matrix[0].size
    if (currentRow - step < -1 || currentColumn + step > rowLength) return null
    var result = matrix[currentRow][currentColumn]
    for (i in 1 until step) {
      result *= matrix[currentRow - i][currentColumn + i]
    }
    return result
  }

  private fun <E> List<List<E>>.hasMatrixTheSameRowLengths(): Boolean {
    val rowLength = this[0].size
    for (i in 1 until this.size) {
      if (this[i].size != rowLength) return false
    }
    return true
  }
}

