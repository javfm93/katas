package katas;

import java.util.*;

class AddTwoNumbers {
  public LinkedList<Integer> execute(LinkedList<Integer> l1, LinkedList<Integer> l2) {
    // single linked lists, reverse order numbers (48 = 8 -> 4)
    var list1 = l1.listIterator();
    var list2 = l2.listIterator();
    var result = new LinkedList<Integer>();
    var carry = 0;
    while (list1.hasNext() && list2.hasNext()) {
      var resultDigit = list1.next() + list2.next() + carry;
      carry = 0;
      if (resultDigit > 9) {
        carry = 1;
        resultDigit = resultDigit % 10;
      }
      result.add(resultDigit);
    }

    while (list1.hasNext()) {
      var resultDigit = list1.next() + carry;
      carry = 0;
      if (resultDigit > 9) {
        carry = 1;
        resultDigit = resultDigit % 10;
      }
      result.add(resultDigit);
    }

    while (list2.hasNext()) {
      var resultDigit = list2.next() + carry;
      carry = 0;
      if (resultDigit > 9) {
        carry = 1;
        resultDigit = resultDigit % 10;
      }
      result.add(resultDigit);
    }

    if (carry > 0) {
      result.add(1);
    }

    return result;
  }
}
