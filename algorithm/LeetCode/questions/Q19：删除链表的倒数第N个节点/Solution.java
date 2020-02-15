import java.util.LinkedList;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode front = head;
        ListNode rear = head;
        for(int i=-1 ; i<n ; i++) {
            if(rear == null) {
                return head.next;
            }
            rear = rear.next;
        }
        while(rear != null) {
            front = front.next;
            rear = rear.next;
        }
        front.next = front.next.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        for(int i=1 ; i<5 ; i++) {
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        int n = 2;
        head.print();
        ListNode result = new Solution().removeNthFromEnd(head, n);
        result.print();
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    @Override
    public String toString() {
        return String.valueOf(val);
    }

    public void print() {
        String result = String.valueOf(val);
        ListNode cur = next;
        while(cur != null) {
            result += " -> " + cur.val;
            cur = cur.next;
        }
        System.out.println(result);
    }
}