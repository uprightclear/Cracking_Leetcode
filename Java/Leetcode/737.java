class Solution {
    public boolean areSentencesSimilarTwo(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        if(sentence1.length != sentence2.length) return false;
        Map<String, Integer> map = new HashMap<>();
        int count = 0;
        UF uf = new UF(similarPairs.size() * 2);
        for(List<String> pair : similarPairs) {
            for(String p : pair) {
                if(!map.containsKey(p)) map.put(p, count++);
            }
            uf.union(map.get(pair.get(0)), map.get(pair.get(1)));
        }
        for(int i = 0; i < sentence1.length; i++) {
            String w1 = sentence1[i], w2 = sentence2[i];
            if(w1.equals(w2)) continue;
            if(!map.containsKey(w1) || !map.containsKey(w2) || uf.find(map.get(w1)) != uf.find(map.get(w2))) return false;
        }
        return true;
    }
}

class UF {
    int[] parent;
    public UF(int n) {
        parent = new int[n];
        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }
    
    public int find(int x) {
        if(parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }
    
    public void union(int x, int y) {
        parent[find(x)] = find(y);
    }
}



class Solution {
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {
        if (words1.length != words2.length) {
            return false;
        }
        
        Map<String, Set<String>> graph = new HashMap<>();
        for (String[] p : pairs) {
            graph.putIfAbsent(p[0], new HashSet<>());
            graph.putIfAbsent(p[1], new HashSet<>());
            graph.get(p[0]).add(p[1]);
            graph.get(p[1]).add(p[0]);
        }
        
        for (int i = 0; i < words1.length; i++) {
            if (words1[i].equals(words2[i])) continue;           
            if (!graph.containsKey(words1[i])) return false;            
            if (!dfs(graph, words1[i], words2[i], new HashSet<>())) return false;
        }
        
        return true;
    }
    
    private boolean dfs(Map<String, Set<String>> graph, String source, String target, Set<String> visited) {
        if (graph.get(source).contains(target)) return true;
        
        if (visited.add(source)) {
            for (String next : graph.get(source)) {
                if (!visited.contains(next) && dfs(graph, next, target, visited)) 
                    return true;
            }
        }
        return false;
    }
}