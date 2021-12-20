class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        // Sort the original array 
        Arrays.sort(arr);
        List<List<Integer>> answer = new ArrayList();

        // Initialize minimum difference as a huge integer in order not 
        // to miss the absolute difference of the first pair. 
        int minPairDiff = Integer.MAX_VALUE;
        
        // Traverse the sorted array and calcalute the minimum absolute difference.
        for (int i = 0; i < arr.length - 1; ++i) {
            minPairDiff = Math.min(minPairDiff, arr[i + 1] - arr[i]);
        }

        // Traverse the sorted array and check every pair again, if 
        // the absolute difference equals the minimum difference, 
        // add this pair to the answer list.        
        for (int i = 0; i < arr.length - 1; ++i) {
            if (arr[i + 1] - arr[i] == minPairDiff) {
                answer.add(Arrays.asList(arr[i], arr[i + 1]));
            }
        }

        return answer;   
    }
}