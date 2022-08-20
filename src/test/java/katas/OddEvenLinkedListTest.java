package katas;

import katas.dataStructures.ListNode;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OddEvenLinkedListTest {

  @Test
  void shouldReturnOddIndexesBeforeEven() {
    var oddEvenLinkedList = new OddEvenLinkedList();
    var l3 = new ListNode(3);
    var l2 = new ListNode(2, l3);
    var input = new ListNode(1, l2);

    var result = oddEvenLinkedList.execute(input);

    var expected3 = new ListNode(2);
    var expected2 = new ListNode(3, expected3);
    var expectedResult = new ListNode(1, expected2);

    assertTrue(expectedResult.equals(result));
  }

  @Test
  void acceptanceTest() {
    var oddEvenLinkedList = new OddEvenLinkedList();
    var l5 = new ListNode(5);
    var l4 = new ListNode(4, l5);
    var l3 = new ListNode(3, l4);
    var l2 = new ListNode(2, l3);
    var input = new ListNode(1, l2);

    var result = oddEvenLinkedList.execute(input);

    var expected5 = new ListNode(4);
    var expected4 = new ListNode(2, expected5);
    var expected3 = new ListNode(5, expected4);
    var expected2 = new ListNode(3, expected3);
    var expectedResult = new ListNode(1, expected2);

    assertTrue(expectedResult.equals(result));
  }

  @Test
  void acceptanceTest2() {
    var oddEvenLinkedList = new OddEvenLinkedList();
    var l7 = new ListNode(7);
    var l6 = new ListNode(6, l7);
    var l5 = new ListNode(5, l6);
    var l4 = new ListNode(4, l5);
    var l3 = new ListNode(3, l4);
    var l2 = new ListNode(2, l3);
    var input = new ListNode(1, l2);

    var result = oddEvenLinkedList.execute(input);

    var expected7 = new ListNode(6);
    var expected6 = new ListNode(4, expected7);
    var expected5 = new ListNode(2, expected6);
    var expected4 = new ListNode(7, expected5);
    var expected3 = new ListNode(5, expected4);
    var expected2 = new ListNode(3, expected3);
    var expectedResult = new ListNode(1, expected2);

    assertTrue(expectedResult.equals(result));
  }

  @Test
  void acceptanceTest3() {
    var oddEvenLinkedList = new OddEvenLinkedList();
    var l6 = new ListNode(6);
    var l5 = new ListNode(5, l6);
    var l4 = new ListNode(4, l5);
    var l3 = new ListNode(3, l4);
    var l2 = new ListNode(2, l3);
    var input = new ListNode(1, l2);

    var result = oddEvenLinkedList.execute(input);

    var expected7 = new ListNode(6);
    var expected6 = new ListNode(4, expected7);
    var expected5 = new ListNode(2, expected6);
    var expected3 = new ListNode(5, expected5);
    var expected2 = new ListNode(3, expected3);
    var expectedResult = new ListNode(1, expected2);

    assertTrue(expectedResult.equals(result));
  }
}
