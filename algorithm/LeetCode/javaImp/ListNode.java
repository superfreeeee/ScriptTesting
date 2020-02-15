package javaImp;

import java.util.ArrayList;
import java.util.List;

public class ListNode {
  int val;
  ListNode next;
  ListNode(int x) { val = x; }

  public static ListNode buildByIntArray(int[] nums) {
    ListNode head = new ListNode(0);
    ListNode cur = head;
    for(int num : nums)
      cur = cur.next = new ListNode(num);
    return head.next;
  }

  public int length() {
    return length(new ArrayList<ListNode>());
  }

  public int length(List<ListNode> recent) {
    if(next == null || recent.contains(next))
      return 1;
    return next.length(recent) + 1;
  }

  public String toString() {
    return toString(new ArrayList<ListNode>());
  }

  public String toString(List<ListNode> recent) {
    if(next == null)
      return String.valueOf(val);

    recent.add(this);
    if(recent.contains(next))
      return val + " -> " + next.val;
    return val + " -> " + next.toString(recent);
    
  }

  public void linkLastTo(int to) {
    if(next == null && to == 0) {
      next = this;
      return;
    }
    ListNode node = this;
    ListNode target = null;
    int count = 0;
    while(node.next != null) {
      if(count++ == to)
        target = node;
      node = node.next;
    }
    node.next = target;
  }

}