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

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n: nums){
            map.put(n, map.getOrDefault(n,0)+1);
        }
           
        PriorityQueue<Integer> pq =  new PriorityQueue<>((a, b) -> (map.get(a) - map.get(b)));
        for(int key : map.keySet()){
            pq.offer(key);
            if(pq.size() > k) pq.poll();
        }
        
        int[] ans = new int[pq.size()];
        int index = ans.length - 1;
        while(index >= 0) ans[index--] = pq.poll();
        return ans;
    }
}