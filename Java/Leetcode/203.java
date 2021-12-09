/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }
}

class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode ans = new ListNode(0);
        ListNode tail = ans;
        tail.next = head;
        
        ListNode node = head;
        while(node != null) {
            if(node.val == val) {
                tail.next = node.next;
            } else {
                tail = tail.next;
            }
            node = node.next;
        }
        return ans.next;
    }
}