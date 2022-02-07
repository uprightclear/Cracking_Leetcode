class Solution {
    public int[] sortEvenOdd(int[] nums) {
        List<Integer> even = new ArrayList<>();
        List<Integer> odd = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            if(i % 2 == 0) even.add(nums[i]);
            else odd.add(nums[i]);
        }
        Collections.sort(even);
        Collections.sort(odd, (a, b) -> b - a);
        int[] ans = new int[nums.length];
        for(int i = 0; i < ans.length; i++) {
            if(i % 2 == 0) {
                ans[i] = even.get(0);
                even.remove(0);
            } else {
                ans[i] = odd.get(0);
                odd.remove(0);
            }
        }
        return ans;
    }
}