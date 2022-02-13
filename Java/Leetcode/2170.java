class Solution {
    public int minimumOperations(int[] nums) {
        Map<Integer, Integer> cntEven = new HashMap<>();
        Map<Integer, Integer> cntOdd = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(i % 2 == 0) cntEven.put(nums[i], cntEven.getOrDefault(nums[i], 0) + 1);
            else cntOdd.put(nums[i], cntOdd.getOrDefault(nums[i], 0) + 1);
        }
        int[] evenMax = getMax(cntEven);
        int[] oddMax = getMax(cntOdd);
        if(evenMax[0] != oddMax[0]) return nums.length - cntEven.getOrDefault(evenMax[0], 0) - cntOdd.getOrDefault(oddMax[0], 0);
        return nums.length - Math.max(
            cntEven.getOrDefault(evenMax[0], 0) + cntOdd.getOrDefault(oddMax[1], 0),
            cntEven.getOrDefault(evenMax[1], 0) + cntOdd.getOrDefault(oddMax[0], 0)
        );
    }
    
    public int[] getMax(Map<Integer, Integer> cnt) {
        int[] res = new int[2];
        for(int x : cnt.keySet()) {
            if(cnt.getOrDefault(res[0], 0) <= cnt.get(x)) {
                res[1] = res[0];
                res[0] = x;
            } else if(cnt.getOrDefault(res[1], 0) <= cnt.get(x)) {
                res[1] = x;
            }
        }
        return res;
    }
}