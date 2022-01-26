/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> inorder(TreeNode root, List<Integer> arr) {
      if (root == null) return arr;
      inorder(root.left, arr);
      arr.add(root.val);
      inorder(root.right, arr);
      return arr;
    }
  
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
      List<Integer> output = new ArrayList<>();
      Stream.of(inorder(root1, new ArrayList()), inorder(root2, new ArrayList())).forEach(output::addAll);
      Collections.sort(output);
      return output;
    }
  }