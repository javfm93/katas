package katas;

import katas.dataStructures.TreeNode;

import java.util.HashMap;

class ConstructBinaryTreefromPreorderandInorderTraversal {
  private final HashMap<Integer, Integer> inOrderIndex = new HashMap<>();
  private int[] preOrder;
  private int lastRootIndex = 0;
  public TreeNode execute(int[] preorder, int[] inorder) {
    if (preorder.length == 1) return new TreeNode(preorder[0]);
    preOrder = preorder;
    for (var i = 0; i < inorder.length; i++) {
      inOrderIndex.put(inorder[i], i);
    }
    return generateSubTree(0, inorder.length - 1);
  }

  private TreeNode generateSubTree(int subTreeStart, int subTreeEnd) {
    if (subTreeStart > subTreeEnd) return null;
    var rootValue = preOrder[lastRootIndex++];
    var root = new TreeNode(rootValue);
    var rootIndexInorder = inOrderIndex.get(rootValue);
    root.left = generateSubTree(subTreeStart, rootIndexInorder - 1);
    root.right = generateSubTree(rootIndexInorder + 1, subTreeEnd );
    return root;
  }
}
