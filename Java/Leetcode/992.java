class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    public int atMost(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        int i = 0, ans = 0;
        for(int r = 0; r < nums.length; r++) {
            if(count.getOrDefault(nums[r], 0) == 0) k--;
            count.put(nums[r], count.getOrDefault(nums[r], 0) + 1);
            while(k < 0) {
                count.put(nums[i], count.get(nums[i]) - 1);
                if(count.get(nums[i]) == 0) k++;
                i++;
            }
            ans += r - i + 1;
        }
        return ans;
    }
}