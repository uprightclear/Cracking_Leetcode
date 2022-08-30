class Solution {
    public int maxSum(int[] nums1, int[] nums2) {
        int i = 0, j = 0, n = nums1.length, m = nums2.length;
        long a = 0, b = 0, mod = (int)1e9 + 7;
        while (i < n || j < m) {
            if (i < n && (j == m || nums1[i] < nums2[j])) {
                a += nums1[i++];
            } else if (j < m && (i == n || nums1[i] > nums2[j])) {
                b += nums2[j++];
            } else {
                a = b = Math.max(a, b) + nums1[i];
                i++; j++;
            }
        }
        return (int)(Math.max(a, b) % mod);
    }
}