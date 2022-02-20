class Solution {
    public int numberOfRounds(String loginTime, String logoutTime) {
        String[] in = loginTime.split(":");
        String[] out = logoutTime.split(":");
        int[] login = {Integer.valueOf(in[0]), Integer.valueOf(in[1])};
        int[] logout = {Integer.valueOf(out[0]), Integer.valueOf(out[1])};
        
        int start = login[0] * 60 + login[1];
        int end = logout[0] * 60 + logout[1];
        
        int startPeriod = start % 15 == 0 ? start / 15 + 1 : start / 15 + 2;
        int a = 96 - startPeriod + 1;
        int endPeriod = end / 15;
        if(end < start) return 96 - startPeriod + 1 + endPeriod;
        if(startPeriod > endPeriod) return 0;
        return endPeriod - startPeriod + 1;
    }
}