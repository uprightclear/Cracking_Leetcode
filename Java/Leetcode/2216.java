class Solution {
    public int minDeletion(int[] nums) {
        int res = 0;
        int index = 0;
        while(index < nums.length) {
            if(index == nums.length - 1) {
                res++;
                break;
            }
            if(nums[index] == nums[index + 1]) {
                index++;
                res++;
            } else {
                index += 2;
            }
        }
        return res;
    }
}