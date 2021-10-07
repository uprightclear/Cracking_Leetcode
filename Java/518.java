//Time limit exceeded
class Solution {
    int count = 0;
    public int change(int amount, int[] coins) {
        Arrays.sort(coins);
        dfs(coins, 0, amount);
        return count;
    }
    
    public void dfs(int[] coins, int start, int target) {
        if(target == 0) {
            count++;
            return;
        }
        
        for(int i = start; i < coins.length; i++) {
            if(target - coins[i] < 0) return;
            dfs(coins, i, target - coins[i]);
        }
    }
}

//bag
class Solution {
    public int change(int amount, int[] coins) {
      int[] dp = new int[amount + 1];
      dp[0] = 1;
  
      for (int coin : coins) {
        for (int x = coin; x < amount + 1; ++x) {
          dp[x] += dp[x - coin];
        }
      }
      return dp[amount];
    }
  }