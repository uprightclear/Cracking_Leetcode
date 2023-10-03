class Solution {
    public long maximumTripletValue(int[] nums) {
        long res = 0, i = 0, j = 0;
        for(int num : nums) {
            res = Math.max(res, 1L * j * num);
            j = Math.max(j, i - num);
            i = Math.max(i, num);
        }
        return res;
    }
}