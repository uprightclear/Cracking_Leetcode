class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        return dfs(s, wordDict, new HashMap<String, List<String>>());
    }
    
    public List<String> dfs(String s, List<String> wordDict, Map<String, List<String>> map) {
        if(map.containsKey(s)) return map.get(s);
        
        List<String> res = new LinkedList<>();
        
        if(s.length() == 0) {
            res.add("");
            return res;
        }
        
        for(String word : wordDict) {
            if(s.startsWith(word)) {
                List<String> subList = dfs(s.substring(word.length()), wordDict, map);
                for(String sub : subList) {
                    res.add(word + (sub.isEmpty() ? "" : " ") + sub);
                }
            }
        }
        
        map.put(s, res);
        
        return res;
    }
}