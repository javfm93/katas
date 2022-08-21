package katas;

import katas.dataStructures.TreeNode;

import java.util.*;

class BinaryTreeZigzagLevelOrderTraversal {
  public List<List<Integer>> execute(TreeNode root) {
    var result = new ArrayList<List<Integer>>(List.of());
    if (root == null ) return result;
    Queue<TreeNode> nextLevelSolutionQueue = new LinkedList<TreeNode>();
    Stack<TreeNode> levelSolutionStack = new Stack<TreeNode>();
    var nexLevelIsLeftToRight = false;
    result.add(List.of(root.val));

    nextLevelSolutionQueue.addAll(getNexLevelPartialSolution(root, nexLevelIsLeftToRight));
    var nextLevel = 1;

    while (!nextLevelSolutionQueue.isEmpty()) {
      nexLevelIsLeftToRight = !nexLevelIsLeftToRight;

      while(!nextLevelSolutionQueue.isEmpty()) {
        var partialLevelSolution = nextLevelSolutionQueue.poll();
        addNodeToFinalLevelResult(result, partialLevelSolution.val, nextLevel);
        levelSolutionStack.push(partialLevelSolution);
      }
      nextLevel++;

      while (!levelSolutionStack.isEmpty()) {
        var levelPartialSolution = levelSolutionStack.pop();
        var nextLevelPartialSolution = getNexLevelPartialSolution(levelPartialSolution, nexLevelIsLeftToRight);
        nextLevelSolutionQueue.addAll(nextLevelPartialSolution);
      }
    }
    return result;
  }

  private static ArrayList<TreeNode> getNexLevelPartialSolution(TreeNode head, boolean nextLevelIsLeftToRight) {
    var partialNextLevelResult = new ArrayList<TreeNode>();
    if (nextLevelIsLeftToRight) {
      if (head.left != null) partialNextLevelResult.add(head.left);
      if (head.right != null) partialNextLevelResult.add(head.right);
    } else {
      if (head.right != null) partialNextLevelResult.add(head.right);
      if (head.left != null) partialNextLevelResult.add(head.left);
    }

    return partialNextLevelResult;
  }

  private static void addNodeToFinalLevelResult(List<List<Integer>> result, int partialLevelResult, int level) {
    if (result.size() == level + 1) {
      result.get(level).add(partialLevelResult);
    } else {
      result.add(new ArrayList<Integer>(List.of(partialLevelResult)));
    }
  }
}
