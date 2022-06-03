class Solution {
    public int racecar(int target) {
        int[] f = new int[target + 2];
        //f[0]=0
        f[1] = 1; //A
        f[2] = 4; //AARA 或者 ARRA
        //f[3]=2; //AA
        //f[4]=5; //AARRA
        //f[5]=7; //AARARAA
        //f[6]=5; //AAARA

        int k = 2;
        // S记录连续k个A指令，达到的位置
        int S = 3;
        for (int i = 3; i <= target; i++) {
            if(i == S) {
                f[i] = k++;
                // 2^k - 1
                S = (1 << k) - 1;
            } else {
                // 情况1：连续k个A后，回退
                f[i] = k + 1 + f[S - i];
                // 情况2：连续k-1个A后，回退(0/1/.../k-2)步后，再前进
                for (int back = 0; back <= k - 2; back++) {
                    // 回退后还需前进的距离：i+S(back)-S(k-1)
                    int distance = i + (1 << back) - (1 << (k - 1));
                    f[i] = Math.min(f[i], (k - 1) + 2 + back + f[distance]);
                }
            }
        }
        return f[target];
    }
}