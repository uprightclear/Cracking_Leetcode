class Solution {
    public long smallestNumber(long num) {
        if(num < 0) return -max(-num);
        return min(num);
    }
    
    private long max(long num) {
        int[] d = cnt(num);
        long res = 0;
        for(int i = 9; i >= 0; i--) {
            for(int j = 0; j < d[i]; j++) {
                res = res * 10 + i;
            }
        } 
        return res;
    }
    
    private long min(long num) {
        int[] d = cnt(num);
        long res = 0;
        for(int i = 1; i <= 9; i++) {
            if(d[i] > 0) {
                res = i;
                d[i]--;
                break;
            }
        }
        for(int i = 0; i <= 9; i++) {
            for(int j = 0; j < d[i]; j++) {
                res = res * 10 + i;
            }
        }
        return res;
    }
    
    private int[] cnt(long num) {
        int[] res = new int[10];
        while(num > 0) {
            res[(int)(num % 10)]++;
            num /= 10;
        }
        return res;
    }
}