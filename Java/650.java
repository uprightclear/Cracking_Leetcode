class Solution {
    public int minSteps(int n) {
        int[] f = new int[n + 1];
        for (int i = 2; i <= n; ++i) {
            f[i] = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; ++j) {
                if (i % j == 0) {
                    f[i] = Math.min(f[i], f[j] + i / j);
                    f[i] = Math.min(f[i], f[i / j] + j);
                }
            }
        }
        return f[n];
    }
}


class Solution {
    public int minSteps(int n) {
        //从 目标个数为n，屏幕A的个数为1，粘贴板中的个数为0，执行次数为0 的状态走起
        return dp(n, 1, 0, 0);
    }

    public int dp(int target_A, int current_A, int copy_A, int steps){
        //屏幕的A数已达标，则返回操作次数
        if(current_A == target_A){
            return steps;
        }
        //屏幕的A数已超过的话，那就没救了，返回最大值
        if(current_A > target_A){
            return Integer.MAX_VALUE;
        }

        //操作次数+1
        steps++;

        if(copy_A == 0){    
            //粘贴板的数量为0时，就只能执行Copy All操作了，也就是把当前屏幕的A数量复制到当前粘贴板
            return dp(target_A, current_A, current_A, steps);
        }
        if(copy_A >= current_A){    
            //粘贴板的数量不比当前屏幕的A少时，就没必要还去Copy All了，只能执行Paste操作
            return dp(target_A, current_A + copy_A, copy_A, steps);
        }else{
            //当粘贴板的数量比当前屏幕A的数量少时，就有两种选择了，要么执行Copy All，要么执行Paste。
            //所以返回他们操作数最小的那个就可以了。
            return Math.min(dp(target_A, current_A, current_A, steps),
                            dp(target_A, current_A + copy_A, copy_A, steps));
        }
    }

}