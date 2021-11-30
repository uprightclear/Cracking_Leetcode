/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/

class Solution {
    // the smallest (first) and the largest (last) nodes
    Node first = null;
    Node last = null;
  
    public void helper(Node node) {
      if (node != null) {
        // left
        helper(node.left);
          
          
        // node 
        if (last != null) {
          // link the previous node (last)
          // with the current one (node)
          last.right = node;
          node.left = last;
        }
        else { // the current node dosen't have left node
          // keep the smallest node
          // to close DLL later on
          first = node;
        }
        last = node;
          
          
        // right
        helper(node.right);
      }
    }
  
    public Node treeToDoublyList(Node root) {
      if (root == null) return null;
  
      helper(root);
      // close DLL
      last.right = first;
      first.left = last;
      return first;
    }
}