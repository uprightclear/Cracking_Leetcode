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
        dfs(s, begin + 1, res);
        if(!Character.isLetter(s[begin])) return;
        s[begin] ^= 1 << 5;
        dfs(s, begin + 1, res);
        s[begin] ^= 1 << 5;
    }
}