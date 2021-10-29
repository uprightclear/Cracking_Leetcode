class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        if(m > n) return findMedianSortedArrays(nums2, nums1);
        
        if(m == 0) return ((double)nums2[(n - 1) / 2] + (double)nums2[n / 2]) / 2;
        
        int len = m + n;
        int astart = 0, aend = m;
        int cuta, cutb;
        while(astart <= aend) {
            cuta = (astart + aend) / 2;
            cutb = (len + 1) / 2 - cuta;
            double l1 = cuta == 0 ? Integer.MIN_VALUE : nums1[cuta - 1];
            double r1 = cuta == m ? Integer.MAX_VALUE : nums1[cuta];
            double l2 = cutb == 0 ? Integer.MIN_VALUE : nums2[cutb - 1];
            double r2 = cutb == n ? Integer.MAX_VALUE : nums2[cutb];
            
            if(l1 > r2) aend = cuta - 1;
            else if(l2 > r1) astart = cuta + 1;
            else {
                if(len % 2 == 0) return (Math.max(l1, l2) + Math.min(r1, r2)) / 2;
                else return Math.max(l1, l2);
            }
        }
        return -1;
    }
}