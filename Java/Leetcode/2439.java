public class Solution {
    public int minimizeArrayValue(int[] nums) {
        long sum = 0;
        long result = 0;
        for (int index = 0; index < nums.length; ++index) {
            sum += nums[index];
            result = Math.max(result, (sum + index) / (index + 1));
        }
        return (int) result;
    }
}
