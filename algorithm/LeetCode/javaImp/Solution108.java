package javaImp;

/**
 * Solution108
 */
public class Solution108 {

  public TreeNode sortedArrayToBST(int[] nums) {
    if(nums == null || nums.length == 0)
      return null;
    TreeNode root = new TreeNode(nums[0]);
    for(int i=1 ; i<nums.length ; i++) {
      // System.out.println(root);
      // System.out.println("insert " + nums[i]);
      insert(root, nums[i]);
      // System.out.println("after insert:");
      // System.out.println(root);
      root = check(root);
    }
    return root;
  }

  public void insert(TreeNode root, int num) {
    if(num < root.val) {
      if(root.left == null)
        root.left = new TreeNode(num);
      else
        insert(root.left, num);
    }
    else {
      if(root.right == null)
        root.right = new TreeNode(num);
      else 
        insert(root.right, num);
    }
  }

  public TreeNode check(TreeNode root) {
    if(root == null)
      return root;

    root.left = check(root.left);
    root.right= check(root.right);
    // System.out.println("\ncheck:");
    // System.out.println(root);
    // System.out.println(deep(root.left) + " " + deep(root.right));
    if(Math.abs(deep(root.left) - deep(root.right)) > 1)
      root = rotate(root); 
    return root;
  }

  public int deep(TreeNode root) {
    if(root == null)
      return 0;
    else
      return Math.max(deep(root.left), deep(root.right))+1;
  }

  public TreeNode rotate(TreeNode root) {
    // System.out.println("rotate " + root);
    if(deep(root.left) > deep(root.right)) {
      if(deep(root.left.left) > deep(root.left.right))
        root = rotate(root, 1);
      else
        root = rotate(root, 2);
    }
    else {
      if(deep(root.right.left) > deep(root.right.right))
        root = rotate(root, 3);
      else
        root = rotate(root, 4);
    }
    // System.out.println("after rotate " + root);
    return root;
  }

  public TreeNode rotate(TreeNode root, int type) {
    TreeNode temp;
    switch(type) {
      case 1:
        temp = root;
        root = root.left;
        temp.left = root.right;
        root.right = temp;
        break;
      case 2:
        temp = root;
        root = root.left.right;
        root.left = temp.left;
        root.right = temp;
        break;
      case 3:
        temp = root;
        root = root.right.left;
        root.right = temp.right;
        root.left = temp;
        break;
      case 4:
        temp = root;
        root = root.right;
        temp.right = root.left;
        root.left = temp;
        break;
    }
    return root;
  }

  public static void main(String[] args) {
    Solution108 s108 = new Solution108();
    // int[] nums = new int[]{0,1,2,3,4,5};
    int[] nums = new int[]{0,1,2,3,4,5};

    TreeNode root = s108.sortedArrayToBST(nums);
    System.out.println(root);
  }
}

class Solution108_2 {
  public TreeNode sortedArrayToBST(int[] nums) {
    if(nums == null || nums.length == 0)
      return null;
    return sortedArrayToBST(nums, 0, nums.length-1);
  }

  public TreeNode sortedArrayToBST(Integer[] nums) {
    if(nums == null || nums.length == 0)
      return null;
    return sortedArrayToBST(nums, 0, nums.length-1);
  }

  public TreeNode sortedArrayToBST(int[] nums, int left, int right) {
    if(left > right)
      return null;
    int mid = (left + right) / 2;
    TreeNode root = new TreeNode(nums[mid]);
    root.left = sortedArrayToBST(nums, left, mid-1);
    root.right = sortedArrayToBST(nums, mid+1, right);
    return root;
  }

  public TreeNode sortedArrayToBST(Integer[] nums, int left, int right) {
    if(left > right)
      return null;
    int mid = (left + right) / 2;
    if(nums[mid] == null)
      return null;
    TreeNode root = new TreeNode(nums[mid]);
    root.left = sortedArrayToBST(nums, left, mid-1);
    root.right = sortedArrayToBST(nums, mid+1, right);
    return root;
  }

  public static void main(String[] args) {
    Solution108 s108 = new Solution108();
    // int[] nums = new int[]{0,1,2,3,4,5};
    int[] nums = new int[]{0,1,2,3,4,5};

    TreeNode root = s108.sortedArrayToBST(nums);
    System.out.println(root);
  }
}