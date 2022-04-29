class Solution {
    public int smallestRangeI(int[] nums, int k) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for(int num : nums) {
            if(num > max) max = num;
            if(num < min) min = num;
        }
        return max - min > 2 * k ? max - min - 2 * k : 0;
    }
}