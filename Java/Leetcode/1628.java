abstract class Node {
    public abstract int evaluate();
    // define your fields here  
};

class TreeNode extends Node{
    // Constructor 
    String val;
    TreeNode left;
    TreeNode right;
    TreeNode(String val) {
        this.val = val;
    }
    
    // Abstract method cannot have body; so fill in body here.
    public int evaluate() {
        return dfs(this); // use this keyword for current TreeNode object.
    }
    
    private int dfs(TreeNode root) {
        if (root.left == null && root.right == null) {
            return Integer.valueOf(root.val);
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        String operator = root.val;
        int res = 0;
        if (operator.equals("+")) {
            res = left + right;
        } else if (operator.equals("-")) {
            res = left - right;
        } else if (operator.equals("*")) {
            res = left * right;
        } else {
            res = left / right;
        }
        return res;
    }
    
};


/**
 * This is the TreeBuilder class.
 * You can treat it as the driver code that takes the postinfix input 
 * and returns the expression tree represnting it as a Node.
 */

class TreeBuilder {
    String operators = "+-*/";
    Stack<TreeNode> stack = new Stack<>();
    Node buildTree(String[] postfix) {
        for (String str : postfix) {
            if (operators.contains(str)) {
                TreeNode cur = new TreeNode(str);
                cur.right = stack.pop();
                cur.left = stack.pop();
                stack.push(cur);
            } else {
                stack.push(new TreeNode(str));
            }
        }
        return stack.pop();
    }
};


/**
 * Your TreeBuilder object will be instantiated and called as such:
 * TreeBuilder obj = new TreeBuilder();
 * Node expTree = obj.buildTree(postfix);
 * int ans = expTree.evaluate();
 */