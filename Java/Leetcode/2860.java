class Solution {
    public int countWays(List<Integer> nums) {
        Collections.sort(nums);
        int ways = nums.get(0) == 0 ? 0 : 1;
        for (int i = 0; i < nums.size(); ++i) {
        int countWith = i + 1;

        if (countWith > nums.get(i) && (i + 1 == nums.size() || countWith < nums.get(i + 1)))
            ways++;
        }

        return ways;
    }
}