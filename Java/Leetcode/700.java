/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
//递归
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
      if (root == null || val == root.val) return root;
      return val < root.val ? searchBST(root.left, val) : searchBST(root.right, val);
    }
}

//迭代
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
      while (root != null && val != root.val)
        root = val < root.val ? root.left : root.right;
      return root;
    }
}