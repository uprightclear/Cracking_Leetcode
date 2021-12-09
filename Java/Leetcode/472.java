class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> result = new ArrayList<>();
        if (words == null || words.length < 2) {
            return result;
        }
        Arrays.sort(words, (a,b) -> a.length() - b.length());
        
        TrieNode root = new TrieNode();
        for (String word : words) {
            if (check(root, word, 0)) {
                result.add(word);
            } else {
                root.addWord(word);
            }
        }
        
        return result;
    }
    
    public boolean check(TrieNode node, String word, int index) {
        TrieNode curr = node;
        int length = word.length();
        for (int i = index; i < length; i++) {
            char c = word.charAt(i);
            int offset = c - 'a';
            TrieNode child = curr.children[offset];
            if (child == null) {
                return false;
            }
            if (child.word) {
                if(i == length - 1 || check(node, word, i + 1)) {
                    return true;
                }
            }
            curr = child;
        }
        return false;
    }
    
    
}

class TrieNode {
    boolean word;
    TrieNode[] children;
    
    public TrieNode() {
        word = false;
        children = new TrieNode[26];
    }
    
    public void addWord(String word) {
        TrieNode curr = this;
        for(char c : word.toCharArray()) {
            int offset = c - 'a';
            TrieNode child = curr.children[offset];
            if (child == null) {
                child = new TrieNode();
                curr.children[offset] = child;
            }
            curr = child;
        }
        curr.word = true;
    }   
}