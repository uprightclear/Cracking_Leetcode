class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        Map<Integer, Integer> map = new TreeMap<>();
        for(int i : nums) map.put(i, map.getOrDefault(i, 0) + 1);
        for(int i : map.keySet()) {
            if(map.get(i) > 0) for(int j = k - 1; j >= 0; j--) {
                if(map.getOrDefault(i + j, 0) < map.get(i)) return false;
                map.put(i + j, map.get(i + j) - map.get(i));
            }
        }
        return true;
    }
}