/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        if(head == null) return head;
        Node prev = new Node(0, null, head, null);
        dfs(prev, head);
        prev.next.prev = null;
        return prev.next;
    }
    
    public Node dfs(Node prev, Node cur) {
        if(cur == null) return prev;
        cur.prev = prev;
        prev.next = cur;
        
        Node tmp = cur.next;
        
        Node tail = dfs(cur, cur.child);
        cur.child = null;
        
        return dfs(tail, tmp);
    }
}