class MapSum {

    class TrieNode{
        TrieNode[] children = new TrieNode[26];
        int sum;
    }

    TrieNode root;

    /** Initialize your data structure here. */
    public MapSum() {
        root = new TrieNode();
    }
    
    public void insert(String key, int val) {
        TrieNode cur = root;
        for(int i = 0; i < key.length(); i++){
            int index = key.charAt(i) - 'a';
            if(cur.children[index] == null) cur.children[index] = new TrieNode();
            cur = cur.children[index];
        }
        cur.sum = val;
    }
    
    public int sum(String prefix) {
        TrieNode cur = root;
        for(int i = 0; i < prefix.length(); i++){
            int index = prefix.charAt(i) - 'a';
            if(cur.children[index] == null) return 0;
            cur = cur.children[index];
        }
        return dfs(cur);
    }

    public int dfs(TrieNode node){
        int res = node.sum;
        for(TrieNode child : node.children){
            if(child != null){
                res += dfs(child);
            }
        }
        return res;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */