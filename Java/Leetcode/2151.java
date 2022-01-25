class Solution {
    public int maximumGood(int[][] statements) {
        int n = statements.length;
        int res = 0;
        for (int i = 1; i < (1 << n); i++) {
            res = Math.max(res, maximumGood(n, i, statements));
        }
        return res;
    }

    // 若 bin 符合条件，则返回 bin 中 1 的数量
    // 否则返回 0
    private int maximumGood(int n, int bin, int[][] statements) {
        int num1 = 0;
        char[] role = new char[n];
        Arrays.fill(role, (char) 2);
        for (int i = 0; i < n; i++) {
            if ((bin & (1 << i)) > 0) {
                num1++;
                // i 是好人
                if (role[i] == 0) {
                    return 0;
                }
                role[i] = 1;
                for (int j = 0; j < n; j++) {
                    if (statements[i][j] != 2) {
                        if (role[j] != 2 && role[j] != statements[i][j]) {
                            return 0;
                        }
                        role[j] = (char) statements[i][j];
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if ((bin & (1 << i)) > 0) {
                continue;
            }
            // i 是坏人
            if (role[i] == 1) {
                return 0;
            }
        }
        return num1;
    }
}