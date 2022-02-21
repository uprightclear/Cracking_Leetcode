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
    public ListNode mergeNodes(ListNode head) {
        if(head == null) return new ListNode();
        ListNode node = head;
        int tmp = 0;
        ListNode ans = new ListNode();
        ListNode dummy = ans;
        while(node != null) {
            if(node.val == 0) {
                if(tmp != 0) {
                    dummy.next = new ListNode(tmp); 
                    tmp = 0;
                    dummy = dummy.next;
                }
            } else {
                tmp += node.val;
            }
            node = node.next;
        }
        return ans.next;
    }
}