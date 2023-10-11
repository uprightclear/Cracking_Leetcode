class Solution {
    public int minLengthAfterRemovals(List<Integer> nums) {
        int len = nums.size();
        int ans = nums.size();
        int i = 0, j = (len + 1) / 2;
        while(i < len / 2 && j < len) {
            if(nums.get(i++) < nums.get(j++)) ans -= 2;
        }
        return ans;
    }
}