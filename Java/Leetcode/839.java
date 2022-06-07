class Solution {
    public int numSimilarGroups(String[] strs) {
        if(strs.length == 1) return 1;
        int res = 0;
        for(int i = 0; i < strs.length; i++) {
            if(strs[i] == null) continue;
            String str = strs[i];
            strs[i] = null;
            res++;
            dfs(strs, str);
        }
        return res;
    }
    
    public void dfs(String[] arr, String str) {
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == null) continue;
            if(check(str, arr[i])) {
                String s = arr[i];
                arr[i] = null;
                dfs(arr, s);
            }
        }
    }
    
    public boolean check(String s, String t) {
        int cnt = 0, i = 0;
        while(cnt <= 2 && i < s.length()) {
            if(s.charAt(i) != t.charAt(i)) cnt++;
            i++;
        }
        return cnt == 2 || cnt == 0;
    }
}