class Solution {
    public int countWays(List<Integer> nums) {
        Collections.sort(nums);
        //if the first element is greater than 0, then we can select
        int ways = nums.get(0) == 0 ? 0 : 1;
        //judge whether we can select first i + 1 elements
        for (int i = 0; i < nums.size(); ++i) {
            //countWidth: the length of the selected elements
            int countWith = i + 1;

        //if meet condition 1 & condition 2
        if (countWith > nums.get(i) && (i + 1 == nums.size() || countWith < nums.get(i + 1)))
            ways++;
        }

        return ways;
    }
}