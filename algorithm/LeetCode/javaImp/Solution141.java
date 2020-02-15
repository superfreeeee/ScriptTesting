package javaImp;

/**
 * Solution141
 */
public class Solution141 {

  public boolean hasCycle(ListNode head) {
    ListNode fast = head;
    ListNode slow = head;
    while(fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
      if(fast == slow)
        return true;
    }
    return false;
  }

  public static void main(String[] args) {
    Solution141 s = new Solution141();
    int[] nums = new int[]{3,2};
    ListNode root = ListNode.buildByIntArray(nums);    
    // root.linkLastTo(0);
    System.out.println(root);

    boolean result = s.hasCycle(root);
    System.out.println(result);

  }
}