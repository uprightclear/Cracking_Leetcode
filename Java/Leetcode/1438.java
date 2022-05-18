//TLE
class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int ans = 1;
        int n = nums.length;
        if(n == 1) return ans;
        for(int i = 2; i <= n; i++) {
            for(int j = 0; j <= n - i; j++) {
                int max = nums[j], min = nums[j];
                for(int k = 1; k < i; k++) {
                    max = Math.max(max, nums[j + k]);
                    min = Math.min(min, nums[j + k]);
                    if((max - min) > limit) break;
                }
                if((max - min) <= limit) {
                    ans = Math.max(ans, i);
                    break;
                }
            }
        }
        return ans;
    }
}


class Solution {
    public int longestSubarray(int[] A, int limit) {
        int i = 0, j;
        //Sliding Window + TreeMap
        TreeMap<Integer, Integer> m = new TreeMap<>();
        for (j = 0; j < A.length; j++) {
            m.put(A[j], 1 + m.getOrDefault(A[j], 0));
            if (m.lastEntry().getKey() - m.firstEntry().getKey() > limit) {
                m.put(A[i], m.get(A[i]) - 1);
                if (m.get(A[i]) == 0)
                    m.remove(A[i]);
                i++;
            }
        }
        return j - i;
    }
}