class Solution {
    int[][] dp;

    // Helper function to calculate the score difference between two players
    private int score(int[] nums, int l, int r) {
        // If the value for the current left and right indices is already calculated, return it
        if (dp[l][r] != -1) {
            return dp[l][r];
        }

        // Base case: If the left and right indices are the same, return the value at that index (single element)
        if (l == r) {
            return nums[l];
        }

        // Calculate the score difference for the current range by choosing the maximum score
        // from the difference of the current left element and the score of the subarray [l+1, r]
        // or the difference of the current right element and the score of the subarray [l, r-1]
        int left = nums[l] - score(nums, l + 1, r);
        int right = nums[r] - score(nums, l, r - 1);

        // Store the calculated score difference in dp table to avoid redundant calculations
        dp[l][r] = Math.max(left, right);

        // Return the calculated score difference for the current range
        return dp[l][r];
    }

    // Main function to predict if the first player can win the game
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        
        // Initialize the dp table with -1 (uninitialized) values
        dp = new int[n][n];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(dp[i], -1);
        }

        // If the score difference between the two players (calculated from score function) is greater than or equal to 0,
        // then the first player can win, return true; otherwise, the second player wins, return false.
        return score(nums, 0, n - 1) >= 0;
    }
}
