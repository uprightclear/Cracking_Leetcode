class Solution {
    public int minOperations(int[] nums) {
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for(int num : map.keySet()) {
            int val = map.get(num);
            if(val == 1) return -1;
            ans += Math.ceil(val / 3.0);
        }
        return ans;
    }
}