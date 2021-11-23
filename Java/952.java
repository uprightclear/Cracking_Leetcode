class Solution {
    public int largestComponentSize(int[] nums) {
        // int max = 0;
        // for(int num : nums) {
        //     max = Math.max(max, num);
        // }
        int max = Arrays.stream(nums).reduce(nums[0], (x, y) -> x > y ? x : y);
        
        DisjointSetUnion dsu = new DisjointSetUnion(max);
        for(int num : nums) {
            for(int f = 2; f < (int)(Math.sqrt(num)) + 1; f++) {
                if(num % f == 0) {
                    dsu.union(num, f);
                    dsu.union(num, num / f);
                }
            }
        }
        
        int ans = 0;
        Map<Integer, Integer> count = new HashMap<>();
        for(int num : nums) {
            int group = dsu.find(num);
            int cnt = count.getOrDefault(group, 0);
            count.put(group, cnt + 1);
            ans = Math.max(ans, cnt + 1);
        }
        
        return ans;
    }
}

class DisjointSetUnion {
    private int[] parent;
    private int[] size;
    
    public DisjointSetUnion(int size) {
        this.parent = new int[size + 1];
        this.size = new int[size + 1];
        for(int i = 0; i <= size; i++) {
            this.parent[i] = i;
            this.size[i] = 1;
        }
    }
    
    public int find(int x) {
        if(x != this.parent[x]) this.parent[x] = this.find(this.parent[x]);
        return this.parent[x];
    }
    
    public int union(int x, int y) {
        int px = this.find(x);
        int py = this.find(y);
        
        if(px == py) return px;
        
        if(this.size[px] > this.size[py]) {
            int tmp = px;
            px = py;
            py = tmp;
        }
        
        this.parent[px] = py;
        this.size[py] += this.size[px];
        return py;
    }
}