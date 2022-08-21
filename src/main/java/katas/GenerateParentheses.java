package katas;

import java.util.ArrayList;
import java.util.List;

class GenerateParentheses {
  public List<String> execute(int n) {
    var results = new ArrayList<String>();
    var tentativeResult = new char[n*2];
    var numberOfOpenedBracket = 0;
    var numberOfClosedBracket = 0;
    processParenthesis(results, tentativeResult, 0, numberOfOpenedBracket, numberOfClosedBracket, n);
    return results;
  }

  private void processParenthesis(ArrayList<String> results, char[] tentativeResult, int position, int numberOfOpenedBracket, int numberOfClosedBracket, int maxNumberOfParenthesis) {
    if (position < maxNumberOfParenthesis * 2) {
      if (numberOfOpenedBracket < maxNumberOfParenthesis ) {
        tentativeResult[position] = '(';
        processParenthesis(results, tentativeResult, position + 1, numberOfOpenedBracket + 1, numberOfClosedBracket, maxNumberOfParenthesis);
      }
      if (numberOfClosedBracket < numberOfOpenedBracket ) {
        tentativeResult[position] = ')';
        processParenthesis(results, tentativeResult, position + 1, numberOfOpenedBracket, numberOfClosedBracket + 1, maxNumberOfParenthesis);
      }
    } else {
      results.add(String.valueOf(tentativeResult));
    }
  }
}
