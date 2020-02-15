/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while(l1 != null && l2 != null) {
            if(l1.val <= l2.val) {
                cur = cur.next = l1;
                l1 = l1.next;
            } else {
                cur = cur.next = l2;
                l2 = l2.next;
            }
        }
        if(l1 == null) {
            while(l2 != null) {
                cur = cur.next = l2;
                l2 = l2.next;
            }
        }
        if(l2 == null) {
            while(l1 != null) {
                cur = cur.next = l1;
                l1 = l1.next;
            }
        }
        return head.next;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}