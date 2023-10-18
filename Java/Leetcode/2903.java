class Solution {
    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        int min = 0, max = 0, n = nums.length;
        for(int i = indexDifference; i < n; i++) {
            if(nums[i - indexDifference] < nums[min]) min = i - indexDifference;
            if(nums[i - indexDifference] > nums[max]) max = i - indexDifference;
            if(nums[i] - nums[min] >= valueDifference) return new int[]{min, i};
            if(nums[max] - nums[i] >= valueDifference) return new int[]{max, i};
        }
        return new int[] {-1, -1};
    }
}