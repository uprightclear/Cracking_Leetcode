class Solution {
    public int maxLength(int[] ribbons, int k) {
        int l = 0;
        int r = (int) 1e5;
        while (l < r) {
            int mid = (l + r + 1) / 2;
            
            if (!isCutPossible(ribbons, mid, k)) {
                r = mid - 1;
            } else {
                l = mid;
            }
        }
        return l;
    }

    public boolean isCutPossible(int[] ribbons, int length, int k) {
        int count = 0;
        for (int ribbon: ribbons) {
            count += (ribbon / length);
        } // I could've written an early 'return' here to save some computation, but for me, the more "if", the more likely to bug
        return count >= k;
    }
}