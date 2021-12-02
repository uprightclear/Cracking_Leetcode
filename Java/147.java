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
    public ListNode insertionSortList(ListNode head) {
        ListNode ans = new ListNode();
        ListNode cur = head;
        
        while(cur != null) {
            //search from the head of the listnode everytimr
            ListNode pre = ans;
            //find the position where cur should be inserted
            while(pre.next != null && pre.next.val < cur.val) pre = pre.next;
            ListNode next = cur.next;
            //insert the cur between pre & pre.next
            cur.next = pre.next;
            pre.next = cur;
            cur = next;
        }
        return ans.next;
    }
}