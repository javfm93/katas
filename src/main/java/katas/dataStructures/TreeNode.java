package katas.dataStructures;


import java.util.ArrayList;
import java.util.List;

public class TreeNode {
  public int val;
  public TreeNode left;
  public TreeNode right;
  public TreeNode() {}
  public TreeNode(int val) { this.val = val; }
  public TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }

  public List<Integer> inOrder() {
    List<Integer> result = new ArrayList<>();
    this.inOrder2(this, result);
    return result;
  }

  private void inOrder2(TreeNode node, List<Integer> result) {
    if (node != null) {
      inOrder2(node.left, result);
      result.add(node.val);
      inOrder2(node.right, result);
    }
  }

}
