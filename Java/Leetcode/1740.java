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
    Map<Integer, TreeNode> parents = new HashMap<>();
    int ans = 0;
    TreeNode pNode;
    
    public int findDistance(TreeNode root, int p, int q) {
        findTarget(root, p);
        findParents(root);
        dfs(pNode, null, 0, q);
        return ans;
    }
    
    public void findParents(TreeNode node) {
        if (node.left != null) {
            parents.put(node.left.val, node);
            findParents(node.left);
        }
        if (node.right != null) {
            parents.put(node.right.val, node);
            findParents(node.right);
        }
    }
    
    public void findTarget(TreeNode node, int target) {
        if(node == null) return;
        if(node.val == target) {
            pNode = node;
            return;
        }
        findTarget(node.left, target);
        findTarget(node.right, target);
    }
    
    public void dfs(TreeNode node, TreeNode from, int depth, int q) {
        if(node == null) return;
        if(node.val == q) {
            ans = depth;
            return;
        }
        if(node.left != from) {
            dfs(node.left, node, depth + 1, q);
        }
        
        if(node.right != from) {
            dfs(node.right, node, depth + 1, q);
        }
        
        if(parents.get(node.val) != from) {
            dfs(parents.get(node.val), node, depth + 1, q);
        }
    }
}