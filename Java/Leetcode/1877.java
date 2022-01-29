class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int[] arr = new int[nums.length / 2];
        for(int i = 0; i < nums.length / 2; i++) {
            arr[i] = nums[i] + nums[nums.length - 1 - i];
        }
        Arrays.sort(arr);
        return arr[arr.length - 1];
    }
}