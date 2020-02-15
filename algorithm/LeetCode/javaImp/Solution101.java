package javaImp;

/**
 * Solution101
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution101 {

  public boolean isSymmetric(TreeNode root) {
    if(root == null)
      return true;
    return compare(root.left, root.right);
  }

  public boolean compare(TreeNode left, TreeNode right) {
    if(left == null && right == null)
      return true;
    else if(left == null || right == null)
      return false;
    return left.val == right.val 
      && compare(left.right, right.left) 
      && compare(left.left, right.right);
  }
}