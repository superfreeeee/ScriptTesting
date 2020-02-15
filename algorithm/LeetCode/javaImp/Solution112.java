package javaImp;

/**
 * Solution112
 */
public class Solution112 {

  public boolean hasPathSum(TreeNode root, int sum) {
    return hasPathSum(root, sum, 0);
  }

  public boolean hasPathSum(TreeNode node, int sum, int count) {
    if(node == null)
      return false;
    count += node.val;
    if(isLeaf(node))
      return sum == count;
    return hasPathSum(node.left, sum, count)
      || hasPathSum(node.right, sum, count);
  }

  public boolean isLeaf(TreeNode root) {
    return root.left == null && root.right == null;
  }

  public static void main(String[] args) {
    Solution112 s112 = new Solution112();
    Integer[] nums = new Integer[]{5,4,8,11,null,13,4,7,2,null,null,null,1,null,null};
    TreeNode root = TreeNode.buildTree(nums);
    int sum = 22;
    boolean result = s112.hasPathSum(root, sum);
    System.out.println(root);
    System.out.println(result);
  }
}