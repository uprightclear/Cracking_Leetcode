class Solution {
    public int addDigits(int num) {
        if (num == 0) return 0;
        if (num % 9 == 0) return 9;
        return num % 9;
    }
}

class Solution {
    public int addDigits(int num) {
        while(num / 10 > 0) {
            int tmp = 0;
            while(num > 0) {
                tmp += num % 10;
                num /= 10;
            }
            num = tmp;
        }
        return num;
    }
}