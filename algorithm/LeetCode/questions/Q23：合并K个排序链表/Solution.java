import java.util.Arrays;
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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) {
            return null;
        } else if (lists.length == 1) {
            return lists[0];
        }
        LinkedList<ListNode> queue = new LinkedList<>(Arrays.asList(lists));
        while(queue.size() > 1) {
            queue.add(combine(queue.poll(), queue.poll()));
        }
        return queue.getFirst();
    }

    private ListNode combine(ListNode a, ListNode b) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while(a != null || b != null) {
            if(a == null) {
                while(b != null) {
                    cur = cur.next = b;
                    b = b.next;
                }
            } else if(b == null) {
                while(a != null) {
                    cur = cur.next = a;
                    a = a.next;
                }
            } else {
                if(a.val <= b.val) {
                    cur = cur.next = a;
                    a = a.next;
                } else {
                    cur = cur.next = b;
                    b = b.next;
                }
            }
        }
        return head.next;
    }

    private static class ListNode {
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

    public static void main(String[] args) {
        ListNode[] lists = new ListNode[] {
            build(new int[]{1,4,5}),
            build(new int[]{1,3,4}),
            build(new int[]{2,6})
        };
        ListNode result = new Solution().mergeKLists(lists);
        System.out.println(result);
    }

    private static ListNode build(int[] nums) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        for(int i : nums) {
            cur = cur.next = new ListNode(i);
        }
        System.out.println(head.next);
        return head.next;
    }
}
