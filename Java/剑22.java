//顺序查找
class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        int n = 0;
        ListNode node = null;

        for (node = head; node != null; node = node.next) {
            n++;
        }
        for (node = head; n > k; n--) {
            node = node.next;
        }

        return node;
    }
}

//stack
class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        Deque<ListNode> d = new ArrayDeque<>();
        while (head != null) {
            d.addLast(head);
            head = head.next;
        }
        ListNode ans = null;
        while (k-- > 0) ans = d.pollLast();
        return ans;
    }
}

//2 pointers
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode slow = head, fast = head;
        while (k-- > 0) fast = fast.next;
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}