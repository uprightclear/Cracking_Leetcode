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
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if(root != null) post(root, res);
        return res;
    }

    public void post(Node node, List<Integer> res){
        if(node == null) return;
        for(Node child : node.children) post(child, res);
        res.add(node.val);
    }
}

//迭代
class Solution {
    public List<Integer> postorder(Node root) {
        LinkedList<Integer> res = new LinkedList<>();
        if(root == null) return res;

        Deque<Node> stack = new LinkedList<>();
        stack.add(root);
        while(!stack.isEmpty()){
            Node node = stack.poll();
            res.addFirst(node.val);
            for(Node item : node.children) stack.push(item);
        }
        return res;
    }
}