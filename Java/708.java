/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
*/

class Solution {
    public Node insert(Node head, int insertVal) {
        if(head == null) {
            Node newNode = new Node(insertVal, null);
            newNode.next = newNode;
            return newNode;
        }
        
        Node pre = head;
        Node cur = head.next;
        
        while(cur.next != head.next) {
            if(pre.val <= insertVal && insertVal <= cur.val) {
                pre.next = new Node(insertVal, cur);
                return head;
            } else if(pre.val > cur.val) {
                if(insertVal >= pre.val || insertVal <= cur.val) {
                    pre.next = new Node(insertVal, cur);
                    return head;
                }
            }
            pre = cur;
            cur = cur.next;
        }
        
        pre.next = new Node(insertVal, cur);
        return head;
    }
}