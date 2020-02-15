package javaImp;

/**
 * Solution83
 */

 /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution83 {

  public ListNode deleteDuplicates(ListNode head) {
    if(head == null)
      return null;
    int saved = head.val;
    ListNode rev = head;
    while(rev.next != null) {
      if(rev.next.val == saved) {
        rev.next = rev.next.next;
      }
      else {
        saved = rev.next.val;
        rev = rev.next;
      }
    }
    return head;
  }
}
