class Solution {
    public List<Integer> findLonely(int[] nums) {
        List<Integer> ans = new LinkedList<>();
        Map<Integer, Integer> cnt = new HashMap<>();
        for(int num : nums) cnt.put(num, cnt.getOrDefault(num, 0) + 1);
        for(Map.Entry<Integer, Integer> e : cnt.entrySet()) {
            if(e.getValue() != 1 || cnt.containsKey(e.getKey() - 1) || cnt.containsKey(e.getKey() + 1)) continue;
            ans.add(e.getKey());
        }
        return ans;
    }
}