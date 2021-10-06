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
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        // queue of elements [(node, col_index)]
        LinkedList<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        Integer maxWidth = 0;

        queue.addLast(new Pair<>(root, 0));
        while (queue.size() > 0) {
            Pair<TreeNode, Integer> head = queue.getFirst();

            // iterate through the current level
            Integer currLevelSize = queue.size();
            Pair<TreeNode, Integer> elem = null;
            for (int i = 0; i < currLevelSize; ++i) {
                elem = queue.removeFirst();
                TreeNode node = elem.getKey();
                if (node.left != null)
                    queue.addLast(new Pair<>(node.left, 2 * elem.getValue()));
                if (node.right != null)
                    queue.addLast(new Pair<>(node.right, 2 * elem.getValue() + 1));
            }

            // calculate the length of the current level,
            //   by comparing the first and last col_index.
            maxWidth = Math.max(maxWidth, elem.getValue() - head.getValue() + 1);
        }

        return maxWidth;
    }
}