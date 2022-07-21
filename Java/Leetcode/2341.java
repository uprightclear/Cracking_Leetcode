class Solution {
    public int[] numberOfPairs(int[] nums) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for(int num : nums) cnt.put(num, cnt.getOrDefault(num, 0) + 1);
        int n = nums.length;
        int first = 0;
        for(int k : cnt.keySet()) {
            if(cnt.get(k) >= 2) {
                first += cnt.get(k) / 2;
                n -= cnt.get(k) / 2 * 2;
            }
        }
        return new int[]{first, n};
    }
}