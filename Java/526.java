//DFS
class Solution {
    List<Integer>[] match;
    boolean[] vis;
    int num;

    public int countArrangement(int n) {
        vis = new boolean[n + 1];
        match = new List[n + 1];
        for (int i = 0; i <= n; i++) {
            match[i] = new ArrayList<Integer>();
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i % j == 0 || j % i == 0) {
                    match[i].add(j);
                }
            }
        }
        backtrack(1, n);
        return num;
    }

    public void backtrack(int index, int n) {
        if (index == n + 1) {
            num++;
            return;
        }
        for (int x : match[index]) {
            if (!vis[x]) {
                vis[x] = true;
                backtrack(index + 1, n);
                vis[x] = false;
            }
        }
    }
}

//DP
class Solution {
    public int countArrangement(int n) {
        // 用来存储中间结果，f[6] = f[000110] = 数字2、3在前两位时的完美排列数量
        int[] f = new int[1 << n];
        f[0] = 1;
        // 通过 mask 进行枚举，最终目的是为了得到二进制 mask = (11..11)n 时，总的完美排列数 
        for (int mask = 1; mask < (1 << n); mask++) {
            int num = Integer.bitCount(mask);
            // 遍历 mask 的每一位，仍以 mask = 100110 为例，此 mask 代表 2 3 6三个数字在排列的前三位
            // 求三个数字 2 3 6 的完美排列方式，则先确定2 3 6哪些数字能放到第三位，然后累加另外两个数字的完美排列数量来获得
            // 2 3 6，第三位可以为 6，则 f[100110] += f[000110] (2、3在前两位时的完美排列数量)
            // 2 3 6，第三位可以为 3，则 f[100110] += f[100010] (2、6在前两位时的完美排列数量)
            for (int i = 0; i < n; i++) {
                // mask & (1<<i) 用来判断 mask 第 i 位是否为 1，如果为 1，说明第 i+1 个数字被选取
                // ((num % (i + 1)) == 0 || (i + 1) % num == 0) 判断被选取的数字 i+1 能否放到位置 num 上，
                // 即：先从被选取的数字中找到能放到最高位 num 的数字，然后将剩余 num-1 个数字的完美排列方式累加到f[mask]中
                if ((mask & (1 << i)) != 0 && ((num % (i + 1)) == 0 || (i + 1) % num == 0)) {
                    // mask ^ (1 << i) 将 mask 第 i 位设置为 0
                    f[mask] += f[mask ^ (1 << i)];
                }
            }
        }
        return f[(1 << n) - 1];
    }
}