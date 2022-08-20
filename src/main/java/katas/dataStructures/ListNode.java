package katas.dataStructures;


import java.util.ArrayList;

public class ListNode {
  int val;
  public ListNode next;
  public ListNode() {}
  public ListNode(int val) { this.val = val; }
  public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

  public boolean equals(ListNode node) {
    var me = this;
    while (node != null && me != null) {
      if (me.val != node.val) {
        System.err.printf("Expected Node: %s, Found: %s", me.val, node.val);
        return false;
      }
      node = node.next;
      me = me.next;
    }
    return me == null && node == null;
  }
}
