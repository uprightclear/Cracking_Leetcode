class Solution {
    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        int left = 0, right = len - 1;
        while(left <= right){
            int mid = (left + right) / 2;
            if(nums[mid] == target) return mid;
            if(nums[mid] > target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }
}

class Solution {
    public int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length;
        while(l < r) {
            int mid = l + (r - l) / 2;
            if(nums[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        
        return l;
    }
}