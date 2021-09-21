class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int end = 0, ans = 0;
        for(int i = 0; i < nums.length; i++) {
            while(i < nums.length && nums[i] == 0) {
                i++;
            }
            
            end = i;
            while(end < nums.length && nums[end] == 1) {
                end++;
            }
            
            ans = Math.max(ans, end - i);
            i = end;
        }
        return ans;
    }
}


class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int maxCount = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 1) {
                count++;
            }else {
                maxCount = Math.max(maxCount, count);
                count = 0;
            }
        }
        return Math.max(maxCount, count);
    }
}