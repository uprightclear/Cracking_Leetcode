class Solution {
    public int minimumTimeRequired(int[] jobs, int k) {
        Arrays.sort(jobs);
        int n = jobs.length;
        int left = jobs[n - 1];
        int right = jobs[n - 1] * n;
        while(left < right) {
            int[] cap = new int[k];
            int mid = left + (right - left) / 2;
            Arrays.fill(cap, mid);
            if(dfs(jobs, cap, n - 1, k, mid)) right = mid;
            else left = mid + 1;
        }
        return left;
    }
    
    public boolean dfs(int[] jobs, int[] cap, int index, int k, int max) {
        if(index == -1) return true;
        for(int i = 0; i < k; i++) {
            if(cap[i] >= jobs[index]) {
                cap[i] -= jobs[index];
                if(dfs(jobs, cap, index - 1, k, max)) return true;
                cap[i] += jobs[index];
            }
            //在最大容量为max的情况下仍然执行到此，即为该容量下不满足条件，需要剪枝
            if(cap[i] == max) break;
        }
        return false;
    }
}