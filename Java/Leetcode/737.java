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



lass Solution {
    public boolean areSentencesSimilarTwo(
        String[] words1, String[] words2, String[][] pairs) {
        if (words1.length != words2.length) return false;
        Map<String, List<String>> graph = new HashMap();
        for (String[] pair: pairs) {
            for (String p: pair) if (!graph.containsKey(p)) {
                graph.put(p, new ArrayList());
            }
            graph.get(pair[0]).add(pair[1]);
            graph.get(pair[1]).add(pair[0]);
        }

        for (int i = 0; i < words1.length; ++i) {
            String w1 = words1[i], w2 = words2[i];
            Stack<String> stack = new Stack();
            Set<String> seen = new HashSet();
            stack.push(w1);
            seen.add(w1);
            search: {
                while (!stack.isEmpty()) {
                    String word = stack.pop();
                    if (word.equals(w2)) break search;
                    if (graph.containsKey(word)) {
                        for (String nei: graph.get(word)) {
                            if (!seen.contains(nei)) {
                                stack.push(nei);
                                seen.add(nei);
                            }
                        }
                    }
                }
                return false;
            }
        }
        return true;
    }
}