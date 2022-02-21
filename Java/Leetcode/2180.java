class Solution {
    public int countEven(int num) {
        int res = 0;
        for(int i = 1; i <= num; i++) {
            if(digitSum(i) % 2 == 0) res++;
        }
        return res;
    }
    
    public int digitSum(int num) {
        int res = 0;
        while(num > 0) {
            res += num % 10;
            num /= 10;
        }
        return res;
    }
}