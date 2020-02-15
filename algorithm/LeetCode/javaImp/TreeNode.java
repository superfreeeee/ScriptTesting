package javaImp;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) {
    val = x;
  }

  public static TreeNode buildTree(Integer[] nums) {
    if(nums == null || nums.length == 0)
      return null;
    TreeNode root = new TreeNode(nums[0]);
    Queue<TreeNode> list = new LinkedList<>();
    list.add(root);

    TreeNode current = null, next;
    for(int i=1 ; i< nums.length ; i++) {
      next = nums[i] == null? null : new TreeNode(nums[i]);

      if(i % 2 == 1) {
        current = list.poll();
      }
      if(current == null)
        continue;

      if(i % 2 == 1)
        current.left = next;
      else
        current.right = next;
      list.add(next);
    }
    return root;
  }

  public String toString() {
    return toString(0);
  }

  public String toString(int offset) {
    if(left == null && right == null)
      return String.valueOf(val);

    StringBuilder tab = new StringBuilder();
    for(int i=0 ; i<offset ; i++)
      tab.append(" ");

    String leftString = left == null 
      ? "null\n"
      : left.toString(offset+2) + "\n";
    String rightString = right == null 
      ? "null\n"
      : right.toString(offset+2) + "\n";
    return val + ": [\n"
      + tab.toString() + "  " + leftString
      + tab.toString() + "  " + rightString
      + tab.toString() + "]";
  }
}