package katas;

import katas.dataStructures.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConstructBinaryTreefromPreorderandInorderTraversalTest {

  @Test
  void shouldGenerateASingleNode() {
    var builder = new ConstructBinaryTreefromPreorderandInorderTraversal();
    var preOrder = new int[] {1};
    var inOrder = new int[] {1};

    var result = builder.execute(preOrder, inOrder);

    var expected = Arrays.stream(inOrder).boxed().toList();
    assertEquals(expected, result.inOrder());
  }

  @Test
  void shouldGenerateALevel2TreeNode() {
    var builder = new ConstructBinaryTreefromPreorderandInorderTraversal();
    var preOrder = new int[] {1, 2, 3};
    var inOrder = new int[] {2, 1, 3};

    var result = builder.execute(preOrder, inOrder);

    var expected = Arrays.stream(inOrder).boxed().toList();
    assertEquals(expected, result.inOrder());
  }

  @Test
  void shouldGenerateALevel3TreeNode() {
    var builder = new ConstructBinaryTreefromPreorderandInorderTraversal();
    var preOrder = new int[] {1,2,4,5,3,6,7};
    var inOrder = new int[] {4,2,5,1,6,3,7};

    var result = builder.execute(preOrder, inOrder);

    var expected = Arrays.stream(inOrder).boxed().toList();
    assertEquals(expected, result.inOrder());
  }


  @Test
  void shouldGenerateALevel3NotCompleteTreeNode() {
    var zigzagTraversal = new BinaryTreeZigzagLevelOrderTraversal();
    var level3LeftLeft = new TreeNode(4);
    var level3LeftRight = new TreeNode(5);
    var level3RightRight = new TreeNode(7);
    var level2Left = new TreeNode(2, level3LeftLeft, level3LeftRight);
    var level2right = new TreeNode(3, null, level3RightRight);
    var input = new TreeNode(1, level2Left, level2right);

    var result = zigzagTraversal.execute(input);

    var expectedResult = List.of(List.of(1), List.of(3, 2), List.of(4,5,7));
    assertEquals(expectedResult, result);
  }

  @Test
  void shouldTraverseALevel4NotCompleteTreeNode() {
    var zigzagTraversal = new BinaryTreeZigzagLevelOrderTraversal();
    var level4RightRightLeft = new TreeNode(9);
    var level4LeftLeftLeft = new TreeNode(8);
    var level3LeftLeft = new TreeNode(4, level4LeftLeftLeft, null);
    var level3LeftRight = new TreeNode(5);
    var level3RightRight = new TreeNode(7, level4RightRightLeft, null);
    var level2Left = new TreeNode(2, level3LeftLeft, level3LeftRight);
    var level2right = new TreeNode(3, null, level3RightRight);
    var input = new TreeNode(1, level2Left, level2right);

    var result = zigzagTraversal.execute(input);

    var expectedResult = List.of(List.of(1), List.of(3, 2), List.of(4,5,7), List.of(9, 8));
    assertEquals(expectedResult, result);
  }
}
