package katas;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ThreeSumTest  {
  @Test
  void shouldReturnAListWhichSums0WhenTheyAreInOrder() {
    var input = new int[]{ -1,0,1 };
    var tripletGenerator = new ThreeSum();

    var result = tripletGenerator.execute(input);

    var expectedResult = List.of(List.of(-1,0,1));
    assertEquals(expectedResult, result);
  }

  @Test
  void shouldNotUseTheSameArrayElementInTwoPositions() {
    var input = new int[]{  1,2,-2,-1  };
    var tripletGenerator = new ThreeSum();

    var result = tripletGenerator.execute(input);

    var expectedResult = List.of();
    assertEquals(expectedResult, result);
  }

  @Test
  void shouldReturnAListWhichSum0WhenTheElementsAreNotInOrder() {
    var input = new int[]{-1,4,0,1 };
    var tripletGenerator = new ThreeSum();

    var result = tripletGenerator.execute(input);

    var expectedResult = List.of(List.of(-1,0,1));
    assertEquals(expectedResult, result);
  }

  @Test
  void shouldReturnMultipleCombinations() {
    var input = new int[]{ 2,-1,0,-1, 1 };
    var tripletGenerator = new ThreeSum();

    var result = tripletGenerator.execute(input);

    var expectedResult = List.of(List.of(-1,-1,2), List.of(-1, 0, 1));
    assertEquals(expectedResult, result);
  }

  @ParameterizedTest
  @MethodSource("acceptanceTest")
  void shouldReturnTheListOfValidTriplets(int[] input, List<List<Integer>> expectedResult) {
    var tripletGenerator = new ThreeSum();
    var result = tripletGenerator.execute(input);
    assertEquals(expectedResult, result);
  }

  private static Stream<Arguments> acceptanceTest() {
    return Stream.of(
        Arguments.of(new int[]{ -1,0,1,2,-1,-4 }, List.of(List.of(-1,-1,2), List.of(-1,0,1))),
        Arguments.of(new int[]{ 0, 1, 1 }, List.of()),
        Arguments.of(new int[]{ 0, 0, 0 }, List.of(List.of(0,0,0)))
    );
  }
}
