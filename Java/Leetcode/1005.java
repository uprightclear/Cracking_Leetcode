class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        int res = 0;
        List<Integer> list = new ArrayList<>();
        int n = nums.length;
        for (int i : nums) {
            list.add(i);
        }
        Collections.sort(list, (n1, n2) -> Math.abs(n1) - Math.abs(n2));
        for (int i = n - 1; i >= 0; i--) {
            if (k > 0 && list.get(i) < 0) {
                k--;
                res -= list.get(i);
            } else res += list.get(i);
        }
        if (k % 2 == 1) {
            res -= Math.abs(list.get(0)) * 2;
        }
        return res;
    }
}