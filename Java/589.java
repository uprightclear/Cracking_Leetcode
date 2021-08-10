/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
//递归
class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if(root != null) pre(root, res);
        return res;
    }

    public void pre(Node node, List<Integer> res){
        if(node == null) return;
        res.add(node.val);
        for(Node child : node.children) pre(child, res);
    }
}

//迭代
class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;

        Deque<Node> stack = new LinkedList<>();
        stack.add(root);
        while(!stack.isEmpty()){
            Node node = stack.poll();
            res.add(node.val);
            Collections.reverse(node.children);
            for(Node item : node.children) stack.push(item);
        }
        return res;
    }
}