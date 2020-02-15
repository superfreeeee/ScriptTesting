/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while(l1 != null || l2 != null) {
            int num1 = l1 == null ? 0 : l1.val;
            int num2 = l2 == null ? 0 : l2.val;

            carry = add(cur, num1, num2, carry);
            cur = cur.next;
            if(l1 != null)
                l1 = l1.next;
            if(l2 != null)
                l2 = l2.next;
        }
        if(carry != 0) {
            add(cur, 0, 0, carry);
        }
        return head.next;
    }

    public int add(ListNode tail, int num1, int num2, int carry) {
        int result = num1 + num2 + carry;
        carry = result / 10;
        result = result % 10;
        tail.next = new ListNode(result);
        return carry;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}