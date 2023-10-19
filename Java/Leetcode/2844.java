class Solution {
    public int minimumOperations(String num) {
        int ans = num.length(), n = num.length();
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                int t = (num.charAt(i) - '0') + (num.charAt(j) - '0') * 10;
                if (t % 25 == 0) ans = Math.min(ans, n - j - 2);
            }
            if (num.charAt(i) == '0') ans = Math.min(ans, n - 1); // To take the only '0' case
        }
        return ans;
    }
}