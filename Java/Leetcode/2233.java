class Solution {
    public int maximumProduct(int[] nums, int k) {
        int MOD = (int)1e9 + 7;
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int num : nums) heap.add(num);
        
        for(int i = 0; i < k; i++) heap.add(heap.poll() + 1);
        long res = 1;
        while(!heap.isEmpty()) res = (res * heap.poll()) % MOD;
        return (int)res;
    }
}