class Solution {
    public int search(int[] nums, int target) {
        int len = nums.length;
        //if(len == 0) return -1;
        if(len == 1) return nums[0] == target ? 0 : -1;

        int l = 0, r = len - 1;
        while(l <= r){
            int mid = (l + r) / 2;
            if(nums[mid] == target) return mid;

            if(nums[l] <= nums[mid]){//left odered
                if(nums[l] <= target && target < nums[mid]){//in left
                    r = mid - 1;
                }else{
                    l = mid + 1;
                }
            }else{//right ordered
                if(nums[mid] < target && target <= nums[len - 1]){
                    l = mid + 1;
                }else{
                    r = mid - 1;
                }
            }
        }
        return -1;
    }
}