package problem18_maximumpathsumI

data class IntBinaryTree(
    val top: TreeNode<Int>
) {

  // slow for large trees 👎
  fun getMaxPathOfTheTree(): Int {
    return getMaxPath(top, 0)
  }

  private fun getMaxPath(node: TreeNode<Int>?, data: Int): Int {
    if (node == null) {
      return data
    }
    val leftData = getMaxPath(node.left, data + node.data)
    val rightData = getMaxPath(node.right, data + node.data)
    return if (leftData > rightData) {
      leftData
    } else {
      rightData
    }
  }

  // suitable for large trees 👍
  fun getMaxPathOfTheTree2(): Int {
    val copy = this.copy()
    while (top.left != null && top.right != null) {
      copy.removeLastLevel()
    }
    return copy.top.data
  }

  private fun removeLastLevel() {
    var current: TreeNode<Int>? = getLeftElementOfPreLastLevel()
    while (current != null) {
      if (current.left != null && current.right != null) {
        current.data += getBiggerChild(current)
        current.left = null
        current.right = null
        if (current.hasRightBrother()) {
          current = current.getRightBrother()!!
        } else {
          current.right = null
          current = null
        }
      }
    }
  }

  private fun getBiggerChild(current: TreeNode<Int>): Int {
    return if (current.left!!.data > current.right!!.data) {
      current.left!!.data
    } else {
      current.right!!.data
    }
  }

  private fun getLeftElementOfPreLastLevel(): TreeNode<Int> {
    var current = top
    while (current.left != null) {
      current = current.left!!
    }
    return current.parent!!
  }
}