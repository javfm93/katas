package katas;

import katas.dataStructures.ListNode;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LetterCombinationsOfAPhoneNumberTest {

  @Test
  void shouldReturnAllTheCombinationsOfOneDigit() {
    var letterCombinationsOfAPhoneNumber = new LetterCombinationsOfAPhoneNumber();

    var result = letterCombinationsOfAPhoneNumber.execute("2");

    var expectedResult = List.of("a", "b", "c");

    assertEquals(expectedResult.toString(), result.toString());
  }

  @Test
  void shouldReturnAllTheCombinationsOf2Digit() {
    var letterCombinationsOfAPhoneNumber = new LetterCombinationsOfAPhoneNumber();

    var result = letterCombinationsOfAPhoneNumber.execute("23");

    var expectedResult = List.of("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf");

    assertEquals(expectedResult.toString(), result.toString());
  }

}
