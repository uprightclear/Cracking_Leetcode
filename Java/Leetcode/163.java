class Solution {
    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        int start = lower;
        List<List<Integer>> bucket = new ArrayList<>();
        
        for(int num : nums){
            if(start < num){
            bucket.add(Arrays.asList(start, num - 1));
            }
            start = num + 1;
        }

        if(start <= upper){
            bucket.add(Arrays.asList(start, upper));
        }

        return bucket;
    }
}