class Solution {
    public List<String> generateSentences(List<List<String>> synonyms, String text) {
        Map<String, List<String>> graph = new HashMap<>();
        for (List<String> pair : synonyms) {
            String w1 = pair.get(0), w2 = pair.get(1);
            connect(graph, w1, w2);
            connect(graph, w2, w1);
        }
        // BFS
        Set<String> ans = new TreeSet<>();
        Queue<String> q = new LinkedList<>();
        q.offer(text);
        while (!q.isEmpty()) {
            String out = q.remove();
            ans.add(out); // Add to result
            String[] words = out.split("\\s");
            for (int i = 0; i < words.length; i++) {
                if (graph.get(words[i]) == null) continue;
                for (String synonym : graph.get(words[i])) { // Replace words[i] with its synonym
                    words[i] = synonym;
                    String newText = String.join(" ", words);
                    if (!ans.contains(newText)) q.offer(newText);
                }
            }
        }
        return new ArrayList<>(ans);
    }
    void connect(Map<String, List<String>> graph, String v1, String v2) {
        graph.putIfAbsent(v1, new LinkedList<>());
        graph.get(v1).add(v2);
    }
}