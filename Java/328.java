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
    public ListNode oddEvenList(ListNode head) {
       ListNode oddHead = new ListNode(0);
       ListNode oddTail = oddHead;
       ListNode evenHead = new ListNode(0);
       ListNode evenTail = evenHead;

       boolean odd = true;
       while(head != null) {
           if(odd) {
               oddTail.next = head;
               oddTail = oddTail.next;
           } else {
               evenTail.next = head;
               evenTail = evenTail.next;
           }
           head = head.next;
           odd = !odd;
       }

       oddTail.next = evenHead.next;
       evenTail.next = null;

       return oddHead.next;   
    }
}