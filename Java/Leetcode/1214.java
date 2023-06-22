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
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        if (root1 == null || root2 == null) return false;
        int sum = root1.val + root2.val;
        if (sum == target) return true;
        else if (sum > target) return twoSumBSTs(root1.left, root2, target) || twoSumBSTs(root1, root2.left, target);
        else return twoSumBSTs(root1.right, root2, target) || twoSumBSTs(root1, root2.right, target);
    }
}


class Solution {
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        List<Integer> one = new ArrayList<>();
        List<Integer> two = new ArrayList<>();

        fillList(root1, one);
        fillList(root2, two);

        int i=0;
        int j=two.size() - 1;

        while(i < one.size()) {
            if((one.get(i) + two.get(j)) > target) {
                j--;
                if(j < 0) {
                    j = two.size() - 1;
                    i++;
                }
            } else if((one.get(i) + two.get(j)) < target) {
                i++;
                j = two.size() - 1;
            } else {
                return true;
            }
        }

        return false;
    }

    private void fillList(TreeNode root, List<Integer> arr) {
        if(root == null)
            return;
        
        if(root.left != null)
            fillList(root.left, arr);

        arr.add(root.val);

        fillList(root.right, arr);
    }
}