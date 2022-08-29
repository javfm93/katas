package katas;

import java.util.Random;

class FindKthLargest {
  int k;
  public int execute(int[] nums, int k) {
    this.k = k;
    if (nums.length == 1) return nums[0];
    quickSelect(nums, 0, nums.length - 1);
    return nums[nums.length - k];
  }

  private void quickSelect(int[] nums, int start, int end) {
    if (start >= end) return;
    var pivot = pickRandomBetween(start + 1, end);
    swap(nums, pivot, end);
    var left = start;
    var right = end - 1;

    while (left <= right && left < end) {
      if (nums[left] < nums[end]) {
        left++;
      } else if (nums[right] >= nums[end]){
        right--;
      } else {
        swap(nums, left, right);
      }
    }
    swap(nums, end, left);
    if (left > nums.length - k) {
      quickSelect(nums, 0, left -1 );
    }
    quickSelect(nums, left + 1, end);
  }

  private static int pickRandomBetween(int start, int end) {
    return new Random().nextInt((end - start) + 1) + start;
  }

  private void swap(int[] nums, int index1, int index2) {
    var temporalValue = nums[index1];
    nums[index1] = nums[index2];
    nums[index2] = temporalValue;
  }
}
