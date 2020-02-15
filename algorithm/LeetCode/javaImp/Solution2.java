package javaImp;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

class Solution2 {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      ListNode head = new ListNode(0);
      ListNode current = head;
      int c = 0;
      while(l1 != null || l2 != null) {
          int i1 = 0;
          if(l1 != null) {
              i1 = l1.val;
              l1 = l1.next;
          }
          int i2 = 0;
          if(l2 != null) {
              i2 = l2.val;
              l2 = l2.next;
          }
          int sum = i1+i2+c;
          c = sum / 10;
          
          current.next = new ListNode(sum%10);
          current = current.next;
      }
      if(c != 0) {
          current.next = new ListNode(c);
      }
      return head.next;
  }
  public static void main(String[] args) {
    ListNode l1 = new ListNode(0);
    ListNode l2 = new ListNode(0);

    l1 = init(l1, 243);
    l2 = init(l2, 564);

    System.out.println(l1);
    System.out.println(l2);
    System.out.println(new Solution2().addTwoNumbers(l1, l2));
  }

  static ListNode init(ListNode head, int num) {
    ListNode current = head;
    while(num >= 10) {
      current.next = new ListNode(num % 10);
      num /= 10;
      current = current.next;
    }
    current.next = new ListNode(num);

    return head.next;
  }
}
