/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {

    public ListNode reverseKGroup(ListNode head, int k) {
        if(k <= 0) {
            return head;
        }
        ListNode resultHead = new ListNode(0);
        resultHead.next = head;
        ListNode cur = resultHead;
        System.out.println("cur: " + cur);
        while(longerThanK(cur, k)) {
            ListNode temp = moveK(cur, k);
            System.out.println("temp: " + temp);
            cur.next = reverseK(cur, k);
            cur = temp;
            System.out.println("cur: " + cur);
        }
        return resultHead.next;
    }

    private boolean longerThanK(ListNode n, int k) {
        while(k-- > 0) {
            n = n.next;
            if(n == null) {
                return false;
            }
        }
        return true;
    }

    private ListNode moveK(ListNode cur, int k) {
        while(k-- > 0) {
            cur = cur.next;
        }
        return cur;
    }

    private ListNode reverseK(ListNode cur, int k) {
        ListNode innerCur = cur.next;
        ListNode next = null;
        while(k-- > 0) {
            ListNode temp = innerCur;
            innerCur = innerCur.next;
            temp.next = next;
            next = temp;
        }
        return next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        for(int i=1 ; i<6 ; i++) {
            cur = cur.next = new ListNode(i);
        }
        head = head.next;
        System.out.println("head: " + head);
        int k = 2;

        ListNode result = new Solution().reverseKGroup(head, k);
        System.out.println("result: " + result);
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
}