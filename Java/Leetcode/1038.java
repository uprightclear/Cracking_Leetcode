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
class Solution {
    public TreeNode bstToGst(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        inorder(root, list);
        for(int i = list.size() - 2; i >= 0; i--) {
            list.get(i).val += list.get(i + 1).val;
        }
        return root;
    }
    
    public void inorder(TreeNode root, List<TreeNode> list) {
        if(root == null) return;
        inorder(root.left, list);
        list.add(root);
        inorder(root.right, list);
    }
}