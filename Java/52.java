class Solution {

    private int count;
    private int n;
    // 记录某一列是否放置了皇后
    private boolean[] col;
    // 记录主对角线上的单元格是否放置了皇后
    private boolean[] main;
    // 记录了副对角线上的单元格是否放置了皇后
    private boolean[] sub;

    public int totalNQueens(int n) {
        if (n == 0) {
            return 1;
        }

        // 设置成员变量，减少参数传递，具体作为方法参数还是作为成员变量，请参考团队开发规范
        this.n = n;
        this.col = new boolean[n];
        this.main = new boolean[2 * n - 1];
        this.sub = new boolean[2 * n - 1];
        //Deque<Integer> path = new ArrayDeque<>();
        dfs(0);
        return count;
    }

    private void dfs(int row) {
        if (row == n) {
            // 深度优先遍历到下标为 n，表示 [0.. n - 1] 已经填完，得到了一个结果
            count++;
            return;
        }

        // 针对下标为 row 的每一列，尝试是否可以放置
        for (int j = 0; j < n; j++) {
            if (!col[j] && !main[row + j] && !sub[row - j + n - 1]) {
                //path.addLast(j);
                col[j] = true;
                main[row + j] = true;
                sub[row - j + n - 1] = true;

                dfs(row + 1);
                // 递归完成以后，回到之前的结点，需要将递归之前所做的操作恢复

                sub[row - j + n - 1] = false;
                main[row + j] = false;
                col[j] = false;
                //path.removeLast();
            }
        }
    }
}