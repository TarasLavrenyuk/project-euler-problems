package problem18_maximumpathsumI

class TreeNode<T>(
    var data: T,
    var left: TreeNode<T>? = null,
    var right: TreeNode<T>? = null,
    var parent: TreeNode<T>? = null

) {

  fun hasRightBrother(): Boolean {
    return parent != null && parent!!.right != this
  }

  fun getRightBrother(): TreeNode<T>? {
    return if (hasRightBrother()) parent!!.right
    else null
  }
}