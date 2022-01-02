class Solution {
    public int numberOfBeams(String[] bank) {
        int ans = 0;
        int pre = 0;
        for(String s : bank) {
            int count = count1(s);
            if(count > 0) {
                ans += count * pre;
                pre = count;
            }
            
        }
        return ans;
    }
    
    private int count1(String s) {
        int num = 0;
        for(char c : s.toCharArray()) if(c == '1') num++;
        return num;
    }
}