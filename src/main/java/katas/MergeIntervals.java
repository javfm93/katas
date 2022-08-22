package katas;

import java.util.Arrays;
import java.util.LinkedList;

class MergeIntervals {
  int init = 0;
  int end = 1;

  public int[][] execute(int[][] intervals) {
    if (intervals.length == 0) return new int[][]{};
    if (intervals.length == 1) return intervals;

    Arrays.sort(intervals, (a, b) -> Integer.compare(a[init], b[init]));
    var result = new LinkedList<int[]>();
    for (int[] interval : intervals) {
      if (result.isEmpty() || result.getLast()[end] < interval[init]) {
        result.add(interval);
      } else {
        result.getLast()[1] = Math.max(result.getLast()[1], interval[1]);
      }
    }
    return result.toArray(new int[result.size()][2]);
  }
}
