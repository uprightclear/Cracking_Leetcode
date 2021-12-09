class Solution {

    class TrieNode{
        public TrieNode[] children;
        public String word;
        public TrieNode(){
            children = new TrieNode[26];
        }
    }
    private TrieNode trie;

    public void insert(String prefix){
        TrieNode p = trie;
        for(int i = 0; i < prefix.length(); i++){
            int index = prefix.charAt(i) - 'a';
            if(p.children[index] == null) p.children[index] = new TrieNode();
            p = p.children[index];
        }
        p.word = prefix;
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        trie = new TrieNode();
        for(String root : dictionary){
            insert(root);
        }

        StringBuilder res = new StringBuilder();
        for(String word : sentence.split("\\s+")){
            if(res.length() > 0) res.append(" ");
            TrieNode p = trie;
            for(int i = 0; i < word.length(); i++){
                int index = word.charAt(i) - 'a';
                if(p.children[index] == null || p.word != null) break;
                p = p.children[index];
            }
            res.append(p.word != null ? p.word : word);
        }
        return res.toString();

    }
}