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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] ans = new ListNode[k];
        ListNode cur = head;
        int count = 0;
        while(cur != null) {
            cur = cur.next;
            count++;
        }
        int[] nums = new int[k];
        Arrays.fill(nums, count / k);
        int extra = count % k;
        for(int i = 0; i < extra; i++) nums[i]++;

        int index = 0;
        cur = head;
        for(int num : nums) {
            ListNode pre = new ListNode(0);
            ListNode tmp = pre;
            for(int i = 0; i < num; i++) {
                tmp.next = new ListNode(cur.val);
                tmp = tmp.next;
                if(cur != null) cur = cur.next;
            }
            ans[index++] = pre.next;
        }
        return ans;
    }
}




class Solution {
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode cur = root;
        int N = 0;
        while (cur != null) {
            cur = cur.next;
            N++;
        }

        int width = N / k, rem = N % k;

        ListNode[] ans = new ListNode[k];
        cur = root;
        for (int i = 0; i < k; ++i) {
            ListNode head = new ListNode(0), write = head;
            for (int j = 0; j < width + (i < rem ? 1 : 0); ++j) {
                write = write.next = new ListNode(cur.val);
                if (cur != null) cur = cur.next;
            }
            ans[i] = head.next;
        }
        return ans;
    }
}