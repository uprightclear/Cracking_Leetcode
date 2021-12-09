class Solution {
    // Maximum number of bikes is 10
    boolean visited [] = new boolean[10];
    int smallestDistanceSum = Integer.MAX_VALUE;
    
    // Manhattan distance
    private int findDistance(int[] worker, int[] bike) {
        return Math.abs(worker[0] - bike[0]) + Math.abs(worker[1] - bike[1]);
    }
    
    private void minimumDistanceSum(int[][] workers, int workerIndex, int[][] bikes, int currDistanceSum) {
        if (workerIndex >= workers.length) {
            smallestDistanceSum = Math.min(smallestDistanceSum, currDistanceSum);
            return;
        }
        // If the current distance sum is greater than the smallest result 
        // found then stop exploring this combination of workers and bikes
        if (currDistanceSum >= smallestDistanceSum) {
            return;
        }
        for (int bikeIndex = 0; bikeIndex < bikes.length; bikeIndex++) {
            // If bike is available
            if (!visited[bikeIndex]) {
                visited[bikeIndex] = true;
                minimumDistanceSum(workers, workerIndex + 1, bikes, currDistanceSum + findDistance(workers[workerIndex], bikes[bikeIndex]));
                visited[bikeIndex] = false;
            }
        }
    }
    
    public int assignBikes(int[][] workers, int[][] bikes) {
        minimumDistanceSum(workers, 0, bikes, 0);
        return smallestDistanceSum;
    } 
}


class Solution {
    // solution: dp - states {current worker idx, bitmask of taken bikes}
    // time complexity: O(B*W*2^(B))
    public int assignBikes(int[][] workers, int[][] bikes) {
        int[] dp = new int[1 << bikes.length];
        return solve(0, 0, workers, bikes, dp);
    }
    public int solve(int cur, int takenBits, int[][] workers, int[][] bikes, int[] dp) {
        if(cur == workers.length) return 0;
        else if(dp[takenBits] != 0) return dp[takenBits];
        int best = Integer.MAX_VALUE;
        
        for(int i = 0;i < bikes.length; i++) {
            if((takenBits & 1 << i) != 0) continue;
            int dist = Math.abs(workers[cur][0] - bikes[i][0]) + Math.abs(workers[cur][1] - bikes[i][1]);
            best = Math.min(best, dist + solve(cur+1, takenBits | (1 << i), workers, bikes, dp));
        }
        dp[takenBits] = best;
        return best;
    }
}