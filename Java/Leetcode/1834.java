class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        int[] ans = new int[n];
        int[][] extTasks = new int[n][3];
        for(int i = 0; i < n; i++) {
            extTasks[i][0] = i;
            extTasks[i][1] = tasks[i][0];
            extTasks[i][2] = tasks[i][1];
        }
        Arrays.sort(extTasks, (a,b)->a[1] - b[1]);
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> a[2] == b[2] ? a[0] - b[0] : a[2] - b[2]);
        int time = 0;
        int index = 0;
        int t = 0;
        while(index < n) {
            while(t < n && extTasks[t][1] <= time) {
                pq.offer(extTasks[t++]);                
            }
            if(pq.isEmpty()) {
                time = extTasks[t][1];
                continue;
            }
            int[] bestFit = pq.poll();
            ans[index++] = bestFit[0];
            time += bestFit[2];
        }
        return ans;
    }
    
}