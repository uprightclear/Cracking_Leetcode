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
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, Integer> parent = new HashMap<>();
        Map<Integer, TreeNode> valueToNode = new HashMap<>();
        for(int[] desc : descriptions) {
            for(int i = 0; i < 2; i++) {
                if (!valueToNode.containsKey(desc[i])) {
                    valueToNode.put(desc[i], new TreeNode(desc[i]));
                }
            }
            parent.put(desc[1], desc[0]);
            if(desc[2] == 1) {
                valueToNode.get(desc[0]).left = valueToNode.get(desc[1]);
            } else {
                valueToNode.get(desc[0]).right = valueToNode.get(desc[1]);
            }
        }
        int cur = descriptions[0][0];
        while(parent.containsKey(cur)) cur = parent.get(cur);
        return valueToNode.get(cur);
    }
}