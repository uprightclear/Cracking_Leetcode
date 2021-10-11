class Node {
    static final Map<String, BiFunction<Integer, Integer, Integer>> OPERATIONS = 
        Map.ofEntries(
            Map.entry("+", (op1, op2) -> op1 + op2),
            Map.entry("-", (op1, op2) -> op1 - op2),
            Map.entry("*", (op1, op2) -> op1 * op2),
            Map.entry("/", (op1, op2) -> op1 / op2)
        );
    
    Node(String val, Node left, Node right){
        this.val = val;   
        this.left = left;
        this.right = right;
    }
    
    final Node left;
    final Node right;
    final String val;

    public int evaluate(){
        if(OPERATIONS.containsKey(val)){
            return OPERATIONS.get(val).apply(left.evaluate(), right.evaluate());
        }
        return Integer.valueOf(val);
    }
};

class TreeBuilder {
    Node buildTree(String[] postfix) {
        Stack<Node> stack = new Stack<>();
        for(String token: postfix){
            if(Node.OPERATIONS.keySet().contains(token)){
                // operator
                Node o2 = stack.pop();
                Node o1 = stack.pop();
                stack.push(new Node(token, o1, o2));
            } else{
                // operand
                stack.push(new Node(token, null, null));
            }
        }
        return stack.pop();
    }
}


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