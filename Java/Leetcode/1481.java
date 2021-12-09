class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {      
        Map<Integer, Integer> freqMap = new HashMap<>();
        for(int x : arr){
            freqMap.put(x, freqMap.getOrDefault(x, 0) + 1);
        }
        //1-2, 3-3, 4-1, 2-1
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b)-> a.getValue() - b.getValue());
        pq.addAll(freqMap.entrySet());
        
        while(k > 0){
            Map.Entry<Integer, Integer> entry = pq.poll();
            k = k -  entry.getValue();
        }
        
        return k < 0 ? pq.size() + 1 : pq.size();
    }
}