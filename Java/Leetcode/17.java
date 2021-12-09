/**DFS*/
class Solution {
    public List<String> letterCombinations(String digits) {
        String[] d = new String[]{" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        char[] cur = new char[digits.length()];
        List<String> ans = new ArrayList<>();
        dfs(digits, d, 0, cur, ans);
        return ans;
    }

    private void dfs(String digits, String[] d, int l, char[] cur, List<String> ans){
        if(l == digits.length()){
            if(l > 0) ans.add(new String(cur));
            return;
        }

        String s = d[digits.charAt(l) - '0'];

        for (int i = 0; i < s.length(); ++i) {
            cur[l] = s.charAt(i);
            dfs(digits, d, l + 1, cur, ans);            
      }
    }
}


/**BFS*/
class Solution {
    public List<String> letterCombinations(String digits) {
      if (digits.length() == 0) return new ArrayList<String>();
      String[] d = new String[]{" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
      List<String> ans = new ArrayList<>();
      ans.add("");
      //按位遍历
      for (char digit : digits.toCharArray()) {
        List<String> tmp = new ArrayList<>();
        for (String t : ans) {
            //获取第n位对应的字母映射
            String s = d[digits.charAt(l) - '0'];
            //获取对应字母的第n位的所有可能
            for (int i = 0; i < s.length(); ++i)
            tmp.add(t + s.charAt(i));
        }
        ans = tmp;
      }
      
      return ans;
    }
 
}