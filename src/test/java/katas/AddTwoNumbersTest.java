package katas;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AddTwoNumbersTest  {


  @Test
  void shouldSumWhenOneNumberIsEmpty() {
    var addTwoNumbers = new AddTwoNumbers();
    var number1 = new LinkedList<Integer>(List.of());
    var number2 = new LinkedList<Integer>(List.of(4));

    var result = addTwoNumbers.execute(number1, number2);

    var expectedResult = new LinkedList<Integer>(List.of(4));
    assertEquals(expectedResult, result);
  }


  @Test
  void shouldSumTwo1DigitNumbers() {
    var addTwoNumbers = new AddTwoNumbers();
    var number1 = new LinkedList<Integer>(List.of(1));
    var number2 = new LinkedList<Integer>(List.of(4));

    var result = addTwoNumbers.execute(number1, number2);

    var expectedResult = new LinkedList<Integer>(List.of(5));
    assertEquals(expectedResult, result);
  }

  @Test
  void shouldSumTwo2DigitNumbers() {
    var addTwoNumbers = new AddTwoNumbers();
    var number1 = new LinkedList<Integer>(List.of(3, 1));
    var number2 = new LinkedList<Integer>(List.of(4, 4));

    var result = addTwoNumbers.execute(number1, number2);

    var expectedResult = new LinkedList<Integer>(List.of(7, 5));
    assertEquals(expectedResult, result);
  }

  @Test
  void shouldApplyCarry() {
    var addTwoNumbers = new AddTwoNumbers();
    var number1 = new LinkedList<Integer>(List.of(7, 1));
    var number2 = new LinkedList<Integer>(List.of(4,4));

    var result = addTwoNumbers.execute(number1, number2);

    var expectedResult = new LinkedList<Integer>(List.of(1, 6));
    assertEquals(expectedResult, result);
  }

  @Test
  void shouldOutputAnExtraDigitWhenTheMayorDigitCarry() {
    var addTwoNumbers = new AddTwoNumbers();
    var number1 = new LinkedList<Integer>(List.of(7, 8));
    var number2 = new LinkedList<Integer>(List.of(4, 4));

    var result = addTwoNumbers.execute(number1, number2);

    var expectedResult = new LinkedList<Integer>(List.of(1, 3, 1));
    assertEquals(expectedResult, result);
  }

  @Test
  void shouldSumTwoNumbersWhenTheFirstHasMoreLength() {
    var addTwoNumbers = new AddTwoNumbers();
    var number1 = new LinkedList<Integer>(List.of(7, 8, 3));
    var number2 = new LinkedList<Integer>(List.of(4, 4));

    var result = addTwoNumbers.execute(number1, number2);

    var expectedResult = new LinkedList<Integer>(List.of(1, 3, 4));
    assertEquals(expectedResult, result);
  }

  @Test
  void shouldSumTwoNumbersWhenTheSecondHasMoreLength() {
    var addTwoNumbers = new AddTwoNumbers();
    var number1 = new LinkedList<Integer>(List.of(4, 4));
    var number2 = new LinkedList<Integer>(List.of(7, 8, 3));

    var result = addTwoNumbers.execute(number1, number2);

    var expectedResult = new LinkedList<Integer>(List.of(1, 3, 4));
    assertEquals(expectedResult, result);
  }


  @Test
  void shouldSumTwoNumbersWhenTheSecondHasMoreLengthWithCarry() {
    var addTwoNumbers = new AddTwoNumbers();
    var number1 = new LinkedList<Integer>(List.of(4, 4));
    var number2 = new LinkedList<Integer>(List.of(7, 8, 9));

    var result = addTwoNumbers.execute(number1, number2);

    var expectedResult = new LinkedList<Integer>(List.of(1, 3, 0, 1));
    assertEquals(expectedResult, result);
  }

  @Test
  void acceptanceTest() {
    var addTwoNumbers = new AddTwoNumbers();
    var number1 = new LinkedList<Integer>(List.of(9,9,9,9,9,9,9));
    var number2 = new LinkedList<Integer>(List.of(9,9,9,9));

    var result = addTwoNumbers.execute(number1, number2);

    var expectedResult = new LinkedList<Integer>(List.of(8,9,9,9,0,0,0,1));
    assertEquals(expectedResult, result);
  }


}
