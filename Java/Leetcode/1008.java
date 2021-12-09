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
    int[] preorder;
    int n;
    public TreeNode bstFromPreorder(int[] preorder) {
        this.preorder = preorder;
        n = preorder.length;
        return dfs(0, n - 1);
    }
    
    public TreeNode dfs(int l, int r) {
        if(l == r) {
            return new TreeNode(preorder[l]);
        }
        if(l > r) return null;
        
        TreeNode node = new TreeNode(preorder[l]);
        int pos = l + 1;
        while(pos < n && preorder[pos] < preorder[l]) pos++;
        node.left = dfs(l + 1, pos - 1);
        node.right = dfs(pos, r);
        return node;
    }
}