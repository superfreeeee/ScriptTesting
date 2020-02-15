package javaImp;


public class Solution21 {

  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode head = new ListNode(0);
    ListNode current = head;
    while(l1 != null || l2 != null) {
      if(l1 == null) {
        current = current.next = l2;
        l2 = l2.next;
      }
      else if(l2 == null) {
        current = current.next = l1;
        l1 = l1.next;
      }
      else {
        if(l1.val > l2.val) {
          current = current.next = l2;
          l2 = l2.next;
        }
        else {
          current = current.next = l1;
          l1 = l1.next;
        }
      }
    }
    return head.next;
  }

  public static void main(String[] args) {
    Solution21 s21 = new Solution21();
    ListNode l1 = init(new int[]{1,2,3,4});
    ListNode l2 = init(new int[]{1,2,3,4});
    ListNode result = s21.mergeTwoLists(l1, l2);
    s21.print(result);
  }

  void print(ListNode ln) {
    while(ln != null) {
      System.out.println(ln);
      ln = ln.next;
    }
  }

  public static ListNode init(int[] nums) {
    ListNode head = new ListNode(0);
    ListNode current = head;
    for(int num : nums)
      current = current.next = new ListNode(num);
    return head.next;
  }
}
