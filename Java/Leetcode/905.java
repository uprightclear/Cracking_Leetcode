class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int len = nums.length;
        int even = 0;
        for(int i = 0; i < len; i++) {
            if(nums[i] % 2 == 0) {
                swap(nums, even, i);
                even++;
            }
        }
        return nums;
    }
    
    private void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}