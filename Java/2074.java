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
    public ListNode reverseEvenLengthGroups(ListNode head) {
        List<Integer> list = new ArrayList<>();
        for(ListNode i = head; i != null; i = i.next) {
            list.add(i.val);
        }
        
        for(int start = 1, len = 2; start < list.size(); ) {
            int end = Math.min(list.size(), start + len);
            if((end - start) % 2 == 0) {
                for(int l = start, r = end - 1; l < r; ) {
                    int t = list.get(l);
                    list.set(l, list.get(r));
                    list.set(r, t);
                    l++;
                    r--;
                }
            }
            start += len;
            len++;
        }
        
        ListNode h = new ListNode(list.get(0));
        ListNode cur = h;
        for(int i = 1; i < list.size(); i++) {
            cur.next = new ListNode(list.get(i));
            cur = cur.next;
        }
        return h;
    }
}