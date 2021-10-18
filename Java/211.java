class WordDictionary {

    class TrieNode{
        TrieNode[] children = new TrieNode[26];
        boolean isEnd = false;
    }

    TrieNode root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode p = root;
        for(int i = 0; i < word.length(); i++){
            int index = word.charAt(i) - 'a';
            if(p.children[index] == null) p.children[index] = new TrieNode();
            p = p.children[index];
        }
        p.isEnd = true;
    }
    
    public boolean search(String word) {
        TrieNode p = root;
        return dfs(word, 0, p);
    }

    public boolean dfs(String word, int deep, TrieNode node){
        if(deep == word.length()){
            if(node.isEnd) return true;
            return false;
        }

        char c = word.charAt(deep);
        if(c == '.'){
            for(int i = 0; i < 26; i++){
                if(node.children[i] != null){
                    if(dfs(word, deep + 1, node.children[i])) return true;
                }
            }
        }else{
            int index = c - 'a';
            if(node.children[index] != null){
                if(dfs(word, deep + 1, node.children[index])) return true;
            }
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */