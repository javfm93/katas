package katas;

class SearchForARange {
  int[] notFound = new int[] {-1, -1};

  public int[] execute(int[] nums, int target) {
    if (nums.length == 0) return notFound;
    if (nums.length == 1)
      return nums[0] == target ? new int[2] : notFound;
    return binarySearch(nums, target, 0, nums.length - 1);
  }

  private int[] binarySearch(int[] nums, int target, int minIndex, int maxIndex) {
    if (maxIndex - 1 == minIndex || nums[minIndex] == target || nums[maxIndex] == target) {
      return finishSearch(nums, target, minIndex, maxIndex);
    }
    var middle = (maxIndex + minIndex) / 2;

    if (target > nums[middle]) {
      return binarySearch(nums, target, middle, maxIndex);
    } else {
      return binarySearch(nums, target, minIndex, middle);
    }
  }

  private int[] finishSearch(int[] nums, int target, int minIndex, int maxIndex) {
    if (nums[minIndex] == target) {
      return calculateResult(nums, target, minIndex);
    }
    if (nums[maxIndex] == target) {
      return calculateResult(nums, target, maxIndex);
    }
    return notFound;
  }

  private int[] calculateResult(int[] nums, int target, int hitIndex) {
    while (hitIndex > 0 && nums[hitIndex - 1] == target) {
      hitIndex--;
    }
    var topRangeIndex = hitIndex;
    while (topRangeIndex < nums.length - 1 && nums[topRangeIndex + 1] == target) {
      topRangeIndex++;
    }

    return new int[]{hitIndex, topRangeIndex};
  }


  }
