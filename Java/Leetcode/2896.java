class Solution {
    public int minOperations(String s1, String s2, int x) {
        // https://leetcode.com/problems/apply-operations-to-make-two-strings-equal/
        // 1 means different, 0 means same.
        // done means min cost we used to make the prefix all 0.
        // two means min cost we used to have one (assume it is index j) and last.
        // one means min cost we used to have one 1 in the prefix
        // last means the last element in the prefix is still 1 and the min cost we used to achieve it.
        int n = s1.length(), done = 0, inf = 1000000, one = inf, last = inf, two = inf; // keep at most 2 in the prefix is enough for this problem
        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) == s2.charAt(i)) {
                last = last + 1; // move the last from A[i - 1] to A[i] with cost = 1
                two = two + 1; // move the last from A[i - 1] to A[i] with cost = 1, ignore another 1 (we don't care which index j it is)
            } else {
                int preOne = one, preLast = last; // need tmp variable since new one and new last will affect
                one = Math.min(done, two + 1); // two + 1 because i-1 is different, and now i is different too, so we flip both of them with cost 1
                last = Math.min(done, two + x); // two + x because we flip i-1 and the j, keep the i stay different so we get new last
                done = Math.min(preOne + x, preLast + 1); // similar logic as above
                two = preOne; // similar logic as above
            }
        }
        return done < inf ? done : -1;
    }
}