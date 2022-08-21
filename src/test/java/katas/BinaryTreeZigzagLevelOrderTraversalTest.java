package katas;

import katas.dataStructures.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinaryTreeZigzagLevelOrderTraversalTest {

  @Test
  void shouldTraverseASingleNode() {
    var zigzagTraversal = new BinaryTreeZigzagLevelOrderTraversal();
    var input = new TreeNode(1);

    var result = zigzagTraversal.execute(input);

    var expectedResult = List.of(List.of(1));
    assertEquals(expectedResult, result);
  }

  @Test
  void shouldTraverseALevel2TreeNode() {
    var zigzagTraversal = new BinaryTreeZigzagLevelOrderTraversal();
    var level2Left = new TreeNode(2);
    var level2right = new TreeNode(3);
    var input = new TreeNode(1, level2Left, level2right);

    var result = zigzagTraversal.execute(input);

    var expectedResult = List.of(List.of(1), List.of(3, 2));
    assertEquals(expectedResult, result);
  }

  @Test
  void shouldTraverseALevel3TreeNode() {
    var zigzagTraversal = new BinaryTreeZigzagLevelOrderTraversal();
    var level3LeftLeft = new TreeNode(4);
    var level3LeftRight = new TreeNode(5);
    var level3RightLeft = new TreeNode(6);
    var level3RightRight = new TreeNode(7);
    var level2Left = new TreeNode(2, level3LeftLeft, level3LeftRight);
    var level2right = new TreeNode(3, level3RightLeft, level3RightRight);
    var input = new TreeNode(1, level2Left, level2right);

    var result = zigzagTraversal.execute(input);

    var expectedResult = List.of(List.of(1), List.of(3, 2), List.of(4,5,6,7));
    assertEquals(expectedResult, result);
  }


  @Test
  void shouldTraverseALevel3NotCompleteTreeNode() {
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
