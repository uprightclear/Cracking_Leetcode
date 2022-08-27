class Solution {
    int result = Integer.MIN_VALUE;
    void updateResult(int[] nums, int k) {
        int sum = 0;

        // Container to store sorted prefix sums.
        TreeSet<Integer> sortedSum = new TreeSet<>();

        // Add 0 as the prefix sum for an empty sub-array.
        sortedSum.add(0);
        for (int num : nums) {
            // Running Sum.
            sum += num;

            // Get X where Running sum - X <= k such that sum - X is closest to k.
            Integer x = sortedSum.ceiling(sum - k);

            // If such X is found in the prefix sums.
            // Get the sum of that sub array and update the global maximum result.
            if (x != null)
                result = Math.max(result, sum - x);

            // Insert the current running sum to the prefix sums container.
            sortedSum.add(sum);
        }
    }
    public int maxSumSubmatrix(int[][] matrix, int k) {
        // Stores the 1D representation of the matrix.
        int[] rowSum = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            // Initialize the 1D representation with 0s.
            Arrays.fill(rowSum, 0);
            // We convert the matrix between rows i..row inclusive to 1D array
            for (int row = i; row < matrix.length; row++) {
                // Add the current row to the previous row.
                // This converts the matrix between i..row to 1D array
                for (int col = 0; col < matrix[0].length; col++)
                    rowSum[col] += matrix[row][col];

                // Run the 1D algorithm for `rowSum`
                updateResult(rowSum, k);

                // If result is k, this is the best possible answer, so return.
                if (result == k)
                    return result;
            }
        }
        return result;
    }
}