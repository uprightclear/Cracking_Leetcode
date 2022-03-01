/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    
    public Node() {
        children = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        children = new ArrayList<Node>();
    }
    
    public Node(int _val,ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    HashMap<Node, Node> visited = new HashMap<>();
    public Node cloneTree(Node root) {
        if(root == null) return root;
        if(visited.containsKey(root)) return visited.get(root);
        Node cloneNode = new Node(root.val, new ArrayList<>());
        visited.put(root, cloneNode);
        for(Node child : root.children) {
            cloneNode.children.add(cloneTree(child));
        }
        return cloneNode;
    }
}