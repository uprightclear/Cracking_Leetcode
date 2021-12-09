class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //<num, frequency>
        Map<Integer, Integer> count = new HashMap<>();
        for(int num : nums) count.put(num, count.getOrDefault(num, 0) + 1);
        
        List<Integer>[] buckets = new ArrayList[nums.length + 1];
        
        for(int i = 0; i <= nums.length; i++) buckets[i] = new ArrayList<>();
        
        for(int num : count.keySet()) {
            buckets[count.get(num)].add(num);
        }
        
        int[] ans = new int[k];
        int index = 0;
        for(int i = nums.length; i >= 0; i--) {
            if(buckets[i].size() == 0) continue;
            for(int j = 0; j < buckets[i].size(); j++) {
                ans[index++] = buckets[i].get(j);
                if(index == k) break;
            }
            if(index == k) break;
        }
        return ans;
    }
}