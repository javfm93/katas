package katas;

import katas.dataStructures.ListNode;
import org.w3c.dom.Node;

import java.util.LinkedList;
class OddEvenLinkedList {
  public ListNode execute(ListNode head) {
    //Space O(1) Time O(n)
    if (head == null) return null;
    if (head.next == null) return head;

    var result = head;
    var lastOdd = head;
    head = head.next;
    var firstEven = head;
    var lastEven = head;
    head = head.next;
    var isOdd = true;

    while(head != null) {
      if (isOdd) {
        lastOdd.next = head;
        head = head.next;
        lastOdd = lastOdd.next;
        lastEven.next = null;
        lastOdd.next = firstEven;
      } else {
        lastEven.next = head;
        lastEven = lastEven.next;
        head = head.next;
      }
      isOdd = !isOdd;
    }
    return result;

  }
}
