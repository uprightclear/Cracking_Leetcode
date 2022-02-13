class Solution {
    public int singleNonDuplicate(int[] nums) {
        int ans = nums[0];
        for(int i = 1; i < nums.length; i++) {
            ans ^= nums[i];
        }
        return ans;
    }
}

class Solution {
    public int singleNonDuplicate(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (nums[mid] == nums[mid ^ 1]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return nums[low];
    }
}