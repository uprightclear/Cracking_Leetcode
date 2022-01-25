class Solution {
    public int countElements(int[] nums) {
        Arrays.sort(nums);
        int start = 0, end = nums.length - 1;
        while (start < end && nums[start] == nums[start + 1]) {
            start++;
        }
        while (start < end && nums[end - 1] == nums[end]) {
            end--;
        }
        return Math.max(end - start - 1, 0);
    }
}