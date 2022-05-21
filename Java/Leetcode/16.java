class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int diff = Integer.MAX_VALUE;
        int size = nums.length;
        Arrays.sort(nums);
        for(int i = 0; i < size && diff != 0; i++) {
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            int l = i + 1, r = nums.length - 1;
            while(l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if(Math.abs(sum - target) < Math.abs(diff)) {
                    diff = target - sum;  
                }
                if(sum < target) l++;
                else r--;
            }
        }
        return target - diff;
    }
}