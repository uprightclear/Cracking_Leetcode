class Solution {
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    public boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return (t1.val == t2.val)
            && isMirror(t1.right, t2.left)
            && isMirror(t1.left, t2.right);
    }
}



class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        mirror(root.right);
        return isSame(root.left, root.right);
    }
    
    public void mirror(TreeNode node) {
        if(node == null) return;
        mirror(node.left);
        mirror(node.right);
        TreeNode tmp = node.left;
        node.left = node.right;
        node.right = tmp;
    }
    
    public boolean isSame(TreeNode a, TreeNode b) {
        if(a == null && b == null) return true;
        if(a == null || b == null) return false;
        return a.val == b.val && isSame(a.left, b.left) && isSame(a.right, b.right);
    }
}