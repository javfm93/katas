package katas;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SetMatrixZeroesTest {

  // [[1,1,1],[1,0,1],[1,1,1]]
  // [1,1,1]
  // [1,0,1]
  // [1,1,1]
  @Test
  void WhenAColumnHasA0ShouldChangeTheWholeColumnTo0() {
    var setMatrixToZeroes = new SetMatrixZeroes();
    var input = new int[][] { new int[] {1, 0, 1} };

    setMatrixToZeroes.execute(input);

    var expectedResult =  new int[][] { new int[] {0, 0, 0} };
    assertArrayEquals(expectedResult, input);
  }

  @Test
  void WhenARowHasA0ShouldChangeTheWholeRowTo0() {
    var setMatrixToZeroes = new SetMatrixZeroes();
    var input = new int[][] { new int[] { 1 }, new int[] { 0 }, new int[] { 1 } };

    setMatrixToZeroes.execute(input);

    var expectedResult =  new int[][] { new int[] { 0 }, new int[] { 0 }, new int[] { 0 } };
    assertArrayEquals(expectedResult, input);
  }

  @Test
  void ShouldChangeMultiple0s() {
    var setMatrixToZeroes = new SetMatrixZeroes();
    var input = new int[][] { new int[] { 1, 1, 1 }, new int[] { 1, 0, 1 }, new int[] { 1, 1, 1 } };

    setMatrixToZeroes.execute(input);

    var expectedResult =  new int[][] { new int[] { 1, 0, 1 }, new int[] { 0, 0, 0 }, new int[] { 1, 0, 1 } };
    assertArrayEquals(expectedResult, input);
  }


  @ParameterizedTest()
  @MethodSource("acceptanceTest")
  void acceptanceTest(int[][] input, int[][] expectedResult) {
    var setMatrixToZeroes = new SetMatrixZeroes();
    setMatrixToZeroes.execute(input);
    assertEquals(Arrays.deepToString(expectedResult), Arrays.deepToString(input));
  }

  private static Stream<Arguments> acceptanceTest() {
    return Stream.of(
        Arguments.of(
            new int[][] { new int[] { 0,1,2,0 }, new int[] { 3,4,5,2 }, new int[] { 1,3,1,5 } },
            new int[][] { new int[] { 0,0,0,0 }, new int[] { 0,4,5,0 }, new int[] { 0,3,1,0 } }),
        Arguments.of(
            new int[][] { new int[] { 1,0 } },
            new int[][] { new int[] { 0,0 } })
    );
  }


}
