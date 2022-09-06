class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> res = new ArrayList<>();
        dfs(s.toCharArray(), 0, res);
        return res;
    }

    private void dfs(char[] s, int begin, List<String> res){
        if(begin == s.length){
            res.add(new String(s));
            return;
        }
        if(!Character.isLetter(s[begin])) {
            dfs(s, begin + 1, res);
            return;
        }
        s[begin] = Character.toLowerCase(s[begin]);
        dfs(s, begin + 1, res);
        
        s[begin] = Character.toUpperCase(s[begin]);
        dfs(s, begin + 1, res);
    }
}