class Solution {
    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for(int task : tasks) cnt.put(task, cnt.getOrDefault(task, 0) + 1);
        int res = 0;
        int[] mem = new int[100001];
        mem[2] = mem[3] = 1;
        mem[4] = mem[5] = 2;
        for(int key : cnt.keySet()) {
            int count = cnt.get(key);
            if(count == 1) return -1;
            res += dp(count, mem);
        }
        return res;
    }
    
    private int dp(int count, int[] mem) {
        if(mem[count] > 0) return mem[count];
        mem[count] = Math.min(dp(count - 3, mem), dp(count - 2, mem)) + 1;
        return mem[count];
    }
}