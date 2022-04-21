class Solution {
    public int findClosestNumber(int[] nums) {
        int res = Integer.MAX_VALUE;
        for(int num : nums)
            if(Math.abs(num) < Math.abs(res) || num == Math.abs(res))
                res = num;
        return res;
    }
}