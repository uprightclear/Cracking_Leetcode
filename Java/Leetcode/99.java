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
    public void recoverTree(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        inOrder(root, list);
        TreeNode x = null;
        TreeNode y = null;
        for(int i = 0; i < list.size() - 1; i++) {
            if(list.get(i).val > list.get(i + 1).val) {
                y = list.get(i + 1);
                if(x == null) {
                    x = list.get(i);
                }
            }
        }
        
        if(x != null && y != null) {
            int tmp = x.val;
            x.val = y.val;
            y.val = tmp;
        }
    }
    
    public void inOrder(TreeNode root, List<TreeNode> list) {
        if(root == null) return;
        inOrder(root.left, list);
        list.add(root);
        inOrder(root.right, list);
    }
}