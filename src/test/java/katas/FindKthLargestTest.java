package katas;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindKthLargestTest {

  @Test
  void shouldReturnTheOnlyElementWhenTheInputsSizeIs1() {
    var findKthLargest = new FindKthLargest();
    var input = new int[] {4};
    var k = 1;

    var result = findKthLargest.execute(input, k);

    assertEquals(4, result);
  }

  @Test
  void shouldReturnTheMayorElementWhenKIs1OnAnUnorderedArrayOfSize2() {
    var findKthLargest = new FindKthLargest();
    var input = new int[] {4, 1};
    var k = 1;

    var result = findKthLargest.execute(input, k);

    assertEquals(4, result);
  }


  @Test
  void shouldReturnTheMayorElementWhenKIs1OnAnOrderedArrayOfSize2() {
    var findKthLargest = new FindKthLargest();
    var input = new int[] {1, 4};
    var k = 1;

    var result = findKthLargest.execute(input, k);

    assertEquals(4, result);
  }

  @Test
  void shouldReturnTheMayorElementWhenKIs1OnAnUnorderedArray() {
    var findKthLargest = new FindKthLargest();
    var input = new int[] {6, 1 ,3, 8, 10, 1};
    var k = 1;

    var result = findKthLargest.execute(input, k);

    assertEquals(10, result);
  }

  @Test
  void shouldReturnTheKthLargest() {
    var findKthLargest = new FindKthLargest();
    var input = new int[] {3,2,1,5,6,4};
    var k = 2;

    var result = findKthLargest.execute(input, k);

    assertEquals(5, result);
  }
}
