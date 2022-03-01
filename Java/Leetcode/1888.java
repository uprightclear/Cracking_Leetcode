class Solution {
    public int minFlips(String str) {
        char[] s = str.toCharArray();
        int n = str.length();
        
        int[] left0 = new int[n];
        int[] left1 = new int[n];
        int[] right0 = new int[n];
        int[] right1 = new int[n];
        
        int sumLeft0 = 0, sumLeft1 = 0;
        for (int i = 0; i < n; i++)
        {
            //flap steps to make odd index with 0 and even index with 1 (010101....)
            if (i % 2 == 0 && s[i] == '1' || i % 2 == 1 && s[i] == '0')
                sumLeft0++;
            //flap steps to make odd index with 1 and even index with 0 (101010....)
            if (i % 2 == 0 && s[i] == '0' || i % 2 == 1 && s[i] == '1')
                sumLeft1++;
            left0[i] = sumLeft0;
            left1[i] = sumLeft1;
        }
        
        int sumRight0 = 0, sumRight1 = 0;
        for (int i = n - 1; i >= 0; i--)
        {
            int j = n - 1 - i;
            //flap steps to make odd index with 0 and even index with 1 from right to left? (010101....)
            if (j % 2 == 0 && s[i] == '1' || j % 2 == 1 && s[i] == '0')
                sumRight0++;
            //flap steps to make odd index with 1 and even index with 0 from right to left? (010101....)
            if (j % 2 == 0 && s[i] == '0' || j % 2 == 1 && s[i] == '1')
                sumRight1++;
            right0[i] = sumRight0;
            right1[i] = sumRight1;
        }
        
        int ret = n;
        ret = Math.min(ret, sumLeft0);
        ret = Math.min(ret, sumLeft1);
        ret = Math.min(ret, sumRight0);
        ret = Math.min(ret, sumRight1);
        
        for (int i = 0; i < n - 1; i++)
        {
            ret = Math.min(ret, left0[i] + right1[i+1]);
            ret = Math.min(ret, left1[i] + right0[i+1]);
        }
        
        return ret;
    }
}