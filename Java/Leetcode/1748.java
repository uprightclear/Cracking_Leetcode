class Solution {
    public int sumOfUnique(int[] nums) {
        if(nums.length == 1) return nums[0];
        int ans = 0;
        Arrays.sort(nums);
        for(int i = 1; i < nums.length - 1; i++) {
            if(nums[i] != nums[i - 1] && nums[i] != nums[i + 1]) ans += nums[i];
        }
        if(nums[0] != nums[1]) ans += nums[0];
        if(nums[nums.length - 1] != nums[nums.length - 2]) ans += nums[nums.length - 1];
        return ans;
    }
}

class Solution {
    public int sumOfUnique(int[] nums) {
        Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();
        for (int num : nums) {
            cnt.put(num, cnt.getOrDefault(num, 0) + 1);
        }
        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : cnt.entrySet()) {
            int num = entry.getKey(), c = entry.getValue();
            if (c == 1) {
                ans += num;
            }
        }
        return ans;
    }
}