class Solution {
    public int[] rearrangeArray(int[] nums) {
        int len = nums.length;
        int[] ans = new int[len];
        Queue<Integer> pos = new LinkedList<>();
        Queue<Integer> neg = new LinkedList<>();
        for(int num : nums) {
            if(num > 0) pos.offer(num);
            else neg.offer(num);
        }
        for(int i = 0; i < len; i++) {
            if(i % 2 == 0) ans[i] = pos.poll();
            else ans[i] = neg.poll();
        }
        return ans;
    }
}