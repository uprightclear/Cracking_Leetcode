class Solution {
    public String alienOrder(String[] words) {
        int[] indegree = new int[26];//深度，字典序越靠后深度越大
        Map<Character, Set<Character>> map = new HashMap<>();
        buildGraph(map, words, indegree);
        return bfs(map, indegree);
    }
    
    private void buildGraph(Map<Character, Set<Character>> map, String[] words, int[] indegree) {
        for(String word : words) {
            for(char c : word.toCharArray()) {
                map.putIfAbsent(c, new HashSet<>());
            }
        }
        for(int i = 1; i < words.length; i++) {
            String first = words[i - 1];
            String second = words[i];
            if(first.startsWith(second) && first.length() > second.length()) {//wrong case
                map.clear();
                return;
            }
            int len = Math.min(first.length(), second.length());
            for(int j = 0; j < len; j++) {
                if(first.charAt(j) != second.charAt(j)) {
                    char out = first.charAt(j);
                    char in = second.charAt(j);
                    if(!map.get(out).contains(in)) {
                        map.get(out).add(in);
                        indegree[in - 'a']++;
                    }
                    break;
                }
            }
        }
    }
    
    private String bfs(Map<Character, Set<Character>> map, int[] indegree) {
        StringBuilder sb = new StringBuilder();
        int totalChars = map.size();
        Queue<Character> q = new LinkedList<>();
        for(char c : map.keySet()) {
            if(indegree[c - 'a'] == 0) {
                sb.append(c);
                q.offer(c);
            }
        }
        
        while(!q.isEmpty()) {
            char out = q.poll();
            if(map.get(out) == null || map.get(out).size() == 0) continue;
            for(char in : map.get(out)) {
                indegree[in - 'a']--;
                if(indegree[in - 'a'] == 0) {
                    q.offer(in);
                    sb.append(in);
                }
            }
        }
        
        return sb.length() == totalChars ? sb.toString() : "";
    }
}