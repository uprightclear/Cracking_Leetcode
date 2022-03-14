class Solution {
    public static int maximumTop(int[] nums, int k) {
        // if size is 1 and k odd stack will be empty
        if (nums.length == 1 && k % 2 == 1) return -1;
        int max = 0;
        //finding the max element from first k-1 elelment or len -1 if len is less than k
        for (int i = 0; i < Math.min(k - 1 ,nums.length); i++)
            max = Math.max(max, nums[i]);
        // check for scenario where we dont have to put back Max out of k-1 element
        if (k < nums.length)
            max = Math.max(max, nums[k]);
        return max;
    }
}