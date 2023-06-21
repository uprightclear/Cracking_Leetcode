class Solution {
    //Time: O(N + N + logN * (N + N)); Space(1)
    //Time: O(N * logN); Space(1)
    public long minCost(int[] nums, int[] cost) {
        long minNum = Integer.MAX_VALUE, maxNum = Integer.MIN_VALUE;
        //Time: O(N)
        for(int n : nums){
            minNum = Math.min(minNum, n);
            maxNum = Math.max(maxNum, n);
        }
        
        //Time: O(N)
        long res = findCost(nums, cost, minNum);

        //Time: O(logN * (N + N))
        while (minNum < maxNum) {
            long mid = (minNum + maxNum) / 2;
            long costLeft = findCost(nums, cost, mid);         //Time: O(N)
            long costRight = findCost(nums, cost, mid + 1); //Time: O(N)
            res = Math.min(costLeft, costRight);
            if (costLeft < costRight) maxNum = mid;
            else minNum = mid + 1;
        }
        return res;
    }

    //Time: O(N)
    private long findCost(int[] nums, int[] cost, long x) {
        long res = 0L;
        for (int i = 0; i < nums.length; i++)
            res += Math.abs(nums[i] - x) * cost[i];
        return res;
    }
}