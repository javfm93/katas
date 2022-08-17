package katas;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


class RomanSymbolToIntegerTest {

  @ParameterizedTest
  @MethodSource("simpleSymbolsProvider")
  void WhenTheSymbolIsSimple_ShouldReturnTheValue(String symbol, Integer expectedValue) {
    var RomanToInteger = new RomanSymbolToInteger();
    var result = RomanToInteger.parse(symbol);
    assertEquals(expectedValue, result);
  }

  @ParameterizedTest
  @MethodSource("complexSymbolsWithSumOperationsProvider")
  void GivenAComplexSymbol_WhenSumOperationsAreRequired_ShouldReturnTheSumOfTheValues(String symbol, Integer expectedValue) {
    var RomanToInteger = new RomanSymbolToInteger();
    var result = RomanToInteger.parse(symbol);
    assertEquals(expectedValue, result);
  }

  @ParameterizedTest
  @MethodSource("complexSymbolsWithRestOperationsProvider")
  void GivenAComplexSymbol_WhenNoOperationsAreRequired_ShouldReturnTheSumOfTheValues(String symbol, Integer expectedValue) {
    var RomanToInteger = new RomanSymbolToInteger();
    var result = RomanToInteger.parse(symbol);
    assertEquals(expectedValue, result);
  }

  @Test
  void WhenSymbolIsIIIShouldReturn3() {
    var RomanToInteger = new RomanSymbolToInteger();
    var result = RomanToInteger.parse("III");
    assertEquals(3, result);
  }

  @Test
  void WhenSymbolIsLVIIIShouldReturn58() {
    var RomanToInteger = new RomanSymbolToInteger();
    var result = RomanToInteger.parse("LVIII");
    assertEquals(58, result);
  }

  @Test
  void WhenSymbolIsMCMXCIVShouldReturn1994() {
    var RomanToInteger = new RomanSymbolToInteger();
    var result = RomanToInteger.parse("MCMXCIV");
    assertEquals(1994, result);
  }
  private static Stream<Arguments> simpleSymbolsProvider() {
    return Stream.of(
        Arguments.of("I", 1),
        Arguments.of("V", 5),
        Arguments.of("X", 10),
        Arguments.of("L", 50),
        Arguments.of("C", 100)
    );
  }
  private static Stream<Arguments> complexSymbolsWithSumOperationsProvider() {
    return Stream.of(
        Arguments.of("II", 2),
        Arguments.of("III", 3),
        Arguments.of("VIII", 8),
        Arguments.of("CL", 150),
        Arguments.of("CLXVI", 166)
    );
  }

  private static Stream<Arguments> complexSymbolsWithRestOperationsProvider() {
    return Stream.of(
        Arguments.of("IV", 4),
        Arguments.of("IX", 9),
        Arguments.of("XL", 40),
        Arguments.of("XC", 90)
    );
  }

}
