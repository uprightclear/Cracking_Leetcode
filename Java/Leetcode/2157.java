class Solution {
    public int[] groupStrings(String[] words) {
        int n = words.length;
        // System.out.println(n);
        UnionFind uf = new UnionFind(n);
        
        // map mask -> original index
        Map<Integer, Integer> map = new HashMap<>();
        int[] mask = new int[n];
        
        for (int i = 0; i < n; i++) {            
            int x = 0;
            char[] temp = words[i].toCharArray();
            for (int j = 0; j < temp.length; j++) {
                char c = temp[j];
                
                // set the (c - 'a')th digit to 1
                x = x | (1 << (c - 'a'));
            }
            map.put(x, i);
            mask[i] = x;
        }
        
		// start checking words one by one, if it has connected words, join them in Union Find
        for (int i = 0; i < n; i++) {
            String current = words[i];
            int len = current.length();
            int x = mask[i];
            
            for (int j = 0; j < len; j++) {
                char c = current.charAt(j);
                
                // delete char at j -> set the (c - 'a')th digit to 0
                x = x & (~(1 << (c - 'a')));
                if (map.containsKey(x)) {
                    int next = map.get(x);
                    uf.join(i, next);
                }               
                
                // replace char at j with 'a' to 'z':
                // replace = delete(already done) + add
                for (char t = 'a'; t <= 'z'; t++) {
                    // take the bit of the (t - 'a')th digit
                    int dig = (x >> (t - 'a')) & 1;
                    if (dig == 1) {
                        // since no letter occurs more than once in words[i], 
                        // if this digit is already 1, we can continue;
                        continue;
                    }
                    
                    // set the (t - 'a')th digit to 1, complete the replacing
                    x = x | (1 << (t - 'a'));                 
                    if (map.containsKey(x)) {
                        int next = map.get(x);
                        uf.join(i, next);
                    }
                    
                    // backtracking , set it back to 0
                    x = x & (~(1 << (t - 'a')));                    
                }
                
                // backtracking, add back the char we delete
                x = x | (1 << (c - 'a'));                           
            }         
        }
        
        // get output from the union Find
        Set<Integer> set = new HashSet<>();
        int max = 1;
        for (int i = 0; i < n; i++) {
            int fx = uf.find(i);
            set.add(fx);
            max = Math.max(max, uf.size[i]);
        }
		
        return new int[] {set.size(), max};
    }  
    
}



class UnionFind {
    
    int[] father;
    int[] size;
    
    public UnionFind(int n) {
        father = new int[n];
        for (int i = 0; i < n; i++) {
            father[i] = i;
        }
        size = new int[n];
        Arrays.fill(size, 1);
    }
    
    public void join(int x, int y) {
        int fx = find(x);
        int fy = find(y);
        if (fx != fy) {
            father[fx] = fy;
            size[fy] += size[fx];
        }
    }
    
    public int find(int x) {
        int root = x;
        while (father[root] != root) {
            root = father[root];
        }
        while (x != root) {
            int fx = father[x];
            father[x] = root;
            x = fx;
        }
        return root;
    }
    
    public boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }
}