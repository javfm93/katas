package katas;

import java.util.HashMap;

class RomanSymbolToInteger {
  public int parse(String s) {
    var fromSymbolToValue = new HashMap<Character, Integer>();
    fromSymbolToValue.put('I', 1);
    fromSymbolToValue.put('V', 5);
    fromSymbolToValue.put('X', 10);
    fromSymbolToValue.put('L', 50);
    fromSymbolToValue.put('C', 100);
    fromSymbolToValue.put('D', 500);
    fromSymbolToValue.put('M', 1000);

    var symbols = s.toCharArray();
    var result = 0;
    char lastSymbol = 'N';
    for (char symbol: symbols) {
      result += fromSymbolToValue.get(symbol);
      if (shouldRest(lastSymbol, symbol)) {
        result -= fromSymbolToValue.get(lastSymbol) * 2;
      }

      lastSymbol = symbol;
    }
    return result;
  }

  private static boolean shouldRest(char lastSymbol, char symbol) {
    var shouldRestDueToI = (symbol == 'V' || symbol == 'X') && lastSymbol == 'I';
    var shouldRestDueToX = (symbol == 'L' || symbol == 'C') && lastSymbol == 'X';
    var shouldRestDueToC = (symbol == 'D' || symbol == 'M') && lastSymbol == 'C';
    return shouldRestDueToI || shouldRestDueToX || shouldRestDueToC;
  }
}
