package javaImp;

/**
 * Solution110
 */
public class Solution110 {

  public boolean isBalanced(TreeNode root) {
    if(root == null)
      return true;
    return Math.abs(deep(root.left) - deep(root.right)) <= 1
      && isBalanced(root.left)
      && isBalanced(root.right);
  }

  public int deep(TreeNode root) {
    if(root == null)
      return 0;
    return Math.max(deep(root.left), deep(root.right)) + 1;
  }
}