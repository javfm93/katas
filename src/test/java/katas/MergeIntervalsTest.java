package katas;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MergeIntervalsTest  {

  @Test
  void ShouldReturnTheIntervalInCaseOfUniqueInput() {
    var mergeIntervals = new MergeIntervals();
    var input = new int[][]{new int[] {1,4}};

    var result = mergeIntervals.execute(input);

    var expectedResult = new int[][]{new int[] {1,4}};
    assertEquals(Arrays.deepToString(expectedResult), Arrays.deepToString(result));
  }

  @Test
  void ShouldReturnAllTheIntervalsInCaseOfNotOverlap() {
    var mergeIntervals = new MergeIntervals();
    var input = new int[][]{new int[] {1,4}, new int[]{6, 8}};

    var result = mergeIntervals.execute(input);

    var expectedResult = new int[][]{new int[] {1,4}, new int[]{6, 8}};
    assertEquals(Arrays.deepToString(expectedResult), Arrays.deepToString(result));
  }

  @Test
  void ShouldMergeTwoIntervalsInCaseOfOverlap() {
    var mergeIntervals = new MergeIntervals();
    var input = new int[][]{new int[] {1,4}, new int[]{2, 5}};

    var result = mergeIntervals.execute(input);

    var expectedResult = new int[][]{new int[] {1,5}};
    assertEquals(Arrays.deepToString(expectedResult), Arrays.deepToString(result));
  }

  @Test
  void ShouldMergeMultipleIntervalsInCaseOfOverlap() {
    var mergeIntervals = new MergeIntervals();
    var input = new int[][]{new int[] {1,4}, new int[]{2, 8}, new int[]{7, 12}};

    var result = mergeIntervals.execute(input);

    var expectedResult = new int[][]{new int[] {1,12}};
    assertEquals(Arrays.deepToString(expectedResult), Arrays.deepToString(result));
  }

  @Test
  void ShouldMergeMultipleIntervalsInCaseOfOverlapAndReturnIntervalsThatNot() {
    var mergeIntervals = new MergeIntervals();
    var input = new int[][]{new int[] {1,2}, new int[]{4, 8}, new int[]{7, 9}, new int[]{12, 15}};

    var result = mergeIntervals.execute(input);

    var expectedResult = new int[][]{new int[] {1,2}, new int[] {4,9}, new int[] {12,15}};
    assertEquals(Arrays.deepToString(expectedResult), Arrays.deepToString(result));
  }

  @Test
  void ShouldMergeIntervalsThatAreContainedByOtherIntervals() {
    var mergeIntervals = new MergeIntervals();
    var input = new int[][]{new int[] {1,2}, new int[]{4, 8}, new int[]{5, 6}, new int[]{6, 6}};

    var result = mergeIntervals.execute(input);

    var expectedResult = new int[][]{new int[] {1,2}, new int[] {4,8}};
    assertEquals(Arrays.deepToString(expectedResult), Arrays.deepToString(result));
  }


  @Test
  void ShouldMergeIntervalsThatAreNotInOrderContainedByOtherIntervals() {
    var mergeIntervals = new MergeIntervals();
    var input = new int[][]{new int[] {14,24}, new int[] {1,2}, new int[]{5, 6}, new int[]{4, 8} , new int[]{6, 6}};

    var result = mergeIntervals.execute(input);

    var expectedResult = new int[][]{new int[] {1,2}, new int[] {4,8}, new int[] {14,24},};
    assertEquals(Arrays.deepToString(expectedResult), Arrays.deepToString(result));
  }



}
