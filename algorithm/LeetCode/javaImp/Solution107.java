package javaImp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Solution107
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
public class Solution107 {

  public List<List<Integer>> levelOrderBottom(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<TreeNode> list = new LinkedList<>();
    List<Integer> current;
    TreeNode node;
    list.add(root);

    int len;
    while((len = list.size()) > 0) {
      System.out.println(len);
      current = new ArrayList<>();
      while(len-- > 0) {
        node = list.pollFirst();
        if(node != null) {
          current.add(node.val);
          list.add(node.left);
          list.add(node.right);
        }
      }
      if(current.size() > 0)
        result.add(0, current);
    }
    return result;
  }
}