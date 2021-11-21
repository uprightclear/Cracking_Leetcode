class Solution {
    //the element remaining
    int n;
    //the sum of the element
    long sum;

    public long kMirror(int k, int n) {
        this.sum = 0;
        this.n = n;
        for (int len = 1; this.n > 0; len++) {
            // the mirror number whose length is len
            char[] chars = new char[len];
            dfs(chars, 0, chars.length - 1, k);
        }
        return sum;
    }

    private void dfs(char[] chars, int i, int j, int k) {
        if (n == 0) return;
        if (i == j) {
            for (int p = 0; p < k; p++) {
                //without leading zero
                if (p == 0 && i == 0) continue;
                chars[i] = (char) ('0' + p);
                dfs(chars, i + 1, j - 1, k);
            }
            return;
        }
        if (i > j) {
            long ten = Long.parseLong(String.valueOf(chars), k);
            String str = String.valueOf(ten);
            for (int l = 0, r = str.length() - 1; l < r; l++, r--) {
                if (str.charAt(l) != str.charAt(r)) return;
            }
            n--;
            sum += ten;
            return;
        }
        for (int p = 0; p < k && this.n > 0; p++) {
            //without leading zero
            if (i == 0 && p == 0) continue;
            chars[i] = chars[j] = (char) ('0' + p);
            dfs(chars, i + 1, j - 1, k);
        }
    }
}