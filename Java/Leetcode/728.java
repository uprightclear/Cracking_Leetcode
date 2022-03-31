class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ans = new ArrayList<>();
        for(int i = left; i <= right; i++) {
            if(isValid(i)) ans.add(i);
        }
        return ans;
    }

    private boolean isValid(int n) {
        int m = n;
        while(m > 0) {
            if(m % 10 > 0 && n % (m % 10) == 0) {
                m /= 10;
            } else return false;
        }
        return true;
    }
}