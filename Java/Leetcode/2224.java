class Solution {
    public int convertTime(String current, String correct) {
        int diff = min(correct) - min(current), ans = 0;
        int[] ops = {60, 15, 5, 1};
        for(int i = 0; i < ops.length && diff > 0; diff = diff % ops[i++]) ans += diff / ops[i];
        return ans;
    }
    
    public int min(String time) {
        String[] t = time.split(":");
        return Integer.valueOf(t[0]) * 60 + Integer.valueOf(t[1]);
    }
}