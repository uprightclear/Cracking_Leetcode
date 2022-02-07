class Solution {
    public int minimumTime(String s) {
        int n = s.length();
        //the min steps to make sure the pre i train meet the requirement
        int[] pre = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            pre[i] = pre[i - 1];
            if(s.charAt(i - 1) == '1') pre[i] = Math.min(pre[i - 1] + 2, i);
        }
        //the min steps to make sure the post i train meet the requirement
        int[] suffix = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            suffix[i] = suffix[i - 1];
            if(s.charAt(n - i) == '1') suffix[i] = Math.min(suffix[i - 1] + 2, i);
        }
        
        int res = Integer.MAX_VALUE;
        for(int i = 0; i <= n; i++) {
            res = Math.min(res, pre[i] + suffix[n - i]);
        }
        
        return res;
    }
}