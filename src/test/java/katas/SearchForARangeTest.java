package katas;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SearchForARangeTest
{

  @Test
  void ShouldReturnTargetWhenInputHas1Element() {
    var searchForARange = new SearchForARange();
    var input = new int[] {1};

    var result = searchForARange.execute(input, 1);

    var expectedResult = new int[] {0, 0};
    assertEquals(Arrays.toString(expectedResult), Arrays.toString(result));
  }

  @Test
  void ShouldReturnTargetWhenInputHas2Element() {
    var searchForARange = new SearchForARange();
    var input = new int[] {1, 2};

    var result = searchForARange.execute(input, 2);

    var expectedResult = new int[] {1, 1};
    assertEquals(Arrays.toString(expectedResult), Arrays.toString(result));
  }

  @Test
  void ShouldReturnTargetWhenInputHasMultipleElement() {
    var searchForARange = new SearchForARange();
    var input = new int[] {1, 2, 6, 7, 10, 59};

    var result = searchForARange.execute(input, 59);

    var expectedResult = new int[] {5, 5};
    assertEquals(Arrays.toString(expectedResult), Arrays.toString(result));
  }

  @Test
  void ShouldReturnTargetWithMultipleMatchesWhenInputHasMultipleElementInTheBeginning() {
    var searchForARange = new SearchForARange();
    var input = new int[] {1, 1, 1, 1, 2, 6, 7, 7, 7, 10, 59, 59};

    var result = searchForARange.execute(input, 1);

    var expectedResult = new int[] {0, 3};
    assertEquals(Arrays.toString(expectedResult), Arrays.toString(result));
  }

  @Test
  void ShouldReturnTargetWithMultipleMatchesWhenInputHasMultipleElementInTheMiddle() {
    var searchForARange = new SearchForARange();
    var input = new int[] {1, 2, 6, 7, 7, 7, 10, 59, 59};

    var result = searchForARange.execute(input, 7);

    var expectedResult = new int[] {3, 5};
    assertEquals(Arrays.toString(expectedResult), Arrays.toString(result));
  }

  @Test
  void ShouldReturnTargetWithMultipleMatchesWhenInputHasMultipleElementAtTheEnd() {
    var searchForARange = new SearchForARange();
    var input = new int[] {1, 2, 6, 7, 10, 59, 59};

    var result = searchForARange.execute(input, 59);

    var expectedResult = new int[] {5, 6};
    assertEquals(Arrays.toString(expectedResult), Arrays.toString(result));
  }


  @Test
  void ShouldReturnNotFound() {
    var searchForARange = new SearchForARange();
    var input = new int[] {1, 2, 6, 7, 10, 59, 59};

    var result = searchForARange.execute(input, 4);

    var expectedResult = new int[] {-1, -1};
    assertEquals(Arrays.toString(expectedResult), Arrays.toString(result));
  }

}
