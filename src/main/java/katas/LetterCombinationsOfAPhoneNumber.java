package katas;

import java.util.*;

class LetterCombinationsOfAPhoneNumber {
  public List<String> execute(String digits) {
    var results = new ArrayList<String>();
    if (digits.isEmpty()) return results;
    var fromNumberToDigit = new HashMap<Character, String>();
    fromNumberToDigit.put('2', "abc");
    fromNumberToDigit.put('3', "def");
    fromNumberToDigit.put('4', "ghi");
    fromNumberToDigit.put('5', "jkl");
    fromNumberToDigit.put('6', "mno");
    fromNumberToDigit.put('7', "pqrs");
    fromNumberToDigit.put('8', "tuv");
    fromNumberToDigit.put('9', "wxyz");
    var digitsList = digits.toCharArray();
    var validCombination = new char[digits.length()];

    processDigit(results, digitsList, validCombination, 0, fromNumberToDigit );

    return results;
  }

  private void processDigit(ArrayList<String> results, char[] digits, char[] validCombination, int position, Map<Character, String> fromNumberToCharacter) {
    if (position < digits.length) {
      var characters = fromNumberToCharacter.get(digits[position]).toCharArray();
      for (Character letter : characters) {
        validCombination[position] = letter;
        processDigit(results, digits, validCombination, position + 1, fromNumberToCharacter);
      }
    } else {
      results.add(String.valueOf(validCombination));
    }
  }
}
