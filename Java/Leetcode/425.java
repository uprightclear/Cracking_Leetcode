class Solution {
    int N = 0;
    String[] words = null;
    HashMap<String, List<String>> prefixHashTable = null;
  
    public List<List<String>> wordSquares(String[] words) {
      this.words = words;
      this.N = words[0].length();
  
      List<List<String>> results = new ArrayList<List<String>>();
      this.buildPrefixHashTable(words);
  
      for (String word : words) {
        LinkedList<String> wordSquares = new LinkedList<String>();
        wordSquares.addLast(word);
        this.backtracking(1, wordSquares, results);
      }
      return results;
    }
  
    protected void backtracking(int step, LinkedList<String> wordSquares, List<List<String>> results) {
      if (step == N) {
        results.add((List<String>) wordSquares.clone());
        return;
      }
  
      StringBuilder prefix = new StringBuilder();
      for (String word : wordSquares) {
        prefix.append(word.charAt(step));
      }
  
      for (String candidate : this.getWordsWithPrefix(prefix.toString())) {
        wordSquares.addLast(candidate);
        this.backtracking(step + 1, wordSquares, results);
        wordSquares.removeLast();
      }
    }
  
    protected void buildPrefixHashTable(String[] words) {
      this.prefixHashTable = new HashMap<String, List<String>>();
  
      for (String word : words) {
        for (int i = 1; i < this.N; ++i) {
          String prefix = word.substring(0, i);
          List<String> wordList = this.prefixHashTable.get(prefix);
          if (wordList == null) {
            wordList = new ArrayList<String>();
            wordList.add(word);
            this.prefixHashTable.put(prefix, wordList);
          } else {
            wordList.add(word);
          }
        }
      }
    }
  
    protected List<String> getWordsWithPrefix(String prefix) {
      List<String> wordList = this.prefixHashTable.get(prefix);
      return (wordList != null ? wordList : new ArrayList<String>());
    }
  }