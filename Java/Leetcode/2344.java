class Solution {
    public int minOperations(int[] nums, int[] numsDivide) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int ans = 0;
        for(int k : map.keySet()) {
            if(check(k, numsDivide)) return ans;
            ans += map.get(k);
        }
        return -1;
    }
    
    public boolean check(int k, int[] arr) {
        for(int n : arr) {
            if(n % k != 0) return false;
        }
        return true;
    }
}