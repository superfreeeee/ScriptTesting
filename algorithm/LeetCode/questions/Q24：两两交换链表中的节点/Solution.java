/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode a = new ListNode(0);
        ListNode b = head;
        head = a;
        head.next = b;
        do {
            a.next = b.next;
            b.next = a.next.next;
            a.next.next = b;
            a = b;
            b = a.next;
        } while(b != null && b.next != null);
        return head.next;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.build(new int[]{1,2,3,4});
        ListNode result = new Solution().swapPairs(head);
        System.out.println(result);
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    @Override
    public String toString() {
        if(next == null) {
            return String.valueOf(val);
        } else {
            return val + " -> " + next.toString();
        }
    }

    public static ListNode build(int[] nums) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        for(int num : nums) {
            cur = cur.next = new ListNode(num);
        }
        return head.next;
    }
}