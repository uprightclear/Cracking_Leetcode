class Solution {
    int i = 1;
    public boolean verifyPreorder(int[] A) {
        return A.length == 0 || check(A, Integer.MIN_VALUE, A[0]) && check(A, A[0], Integer.MAX_VALUE);
    }

    public boolean check(int[] A, int left, int right) {
        //A[i] > right : the current node can only put in the right tree
        if (i == A.length || A[i] > right) return true;
        int mid = A[i++];
        return (mid > left) && check(A, left, mid) && check(A, mid, right);
    }
}
