class Solution {
    public class UF{
        int[] parent;
        int res;
        UF(int size){
            parent = new int[size];
            for(int i = 0; i < size; i++)
                parent[i] = i;
            res = size;
        }
        public int find(int child){
            if(parent[child] != child){
                int p = find(parent[child]); //find parent recursively
                parent[child] = p;//update child's parent
            }
                
            return parent[child];
        }
        public void union(int a, int b){
            int pa = find(a);
            int pb = find(b);
            if(pa != pb){
                parent[pb] = pa;
                res--;//when union happens, we decrement one parent
            }
             
        }
    }
    public int earliestAcq(int[][] logs, int N) {
        Arrays.sort(logs, (a, b) -> (a[0] - b[0]));
        UF uf = new UF(N);
        for(int[]log : logs){
            uf.union(log[1], log[2]);
            if(uf.res == 1)
                return log[0];
        }
        return -1;
    } 
}