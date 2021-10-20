class Solution {
    public int missingNumber(int[] nums) {
        int len = nums.length;
        int sum = (1 + len) * len / 2;
        for(int num : nums) {
            sum -= num;
        }
        return sum;
    }
}