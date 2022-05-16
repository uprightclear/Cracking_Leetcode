class Solution {
    public int countComponents(int n, int[][] edges) {
        int ans = 0;
        boolean[] used = new boolean[n];
        for(int i = 0; i < n; i++) {
            if(!used[i]){
                ans++; 
                dfs(edges, used, i);
            } 
            
            // for(int[] edge : edges) {
            //     for(int element : edge) {
            //         if(element == i) {
            //             used[edge[0]] = true;
            //             used[edge[1]] = true;
            //         }
            //     }
            // }
            
        }
        return ans;
    }
    
    private void dfs(int[][] edges, boolean[] used, int num) {
        if(used[num]) return;
        used[num] = true;
        for(int[] edge : edges) {
            for(int element : edge) {
                if(element == num) {
                    if(edge[0] == num) dfs(edges, used, edge[1]);
                    else dfs(edges, used, edge[0]);
                }
            }
        }
    }
}


//official answer DFS
class Solution {
    
    private void dfs(List<Integer>[] adjList, int[] visited, int startNode) {
       visited[startNode] = 1;
        
       for (int i = 0; i < adjList[startNode].size(); i++) {
           if (visited[adjList[startNode].get(i)] == 0) {
               dfs(adjList, visited, adjList[startNode].get(i));
           }
       }
   }
   
   public int countComponents(int n, int[][] edges) {
       int components = 0;
       int[] visited = new int[n];
       
       List<Integer>[] adjList = new ArrayList[n]; 
       for (int i = 0; i < n; i++) {
           adjList[i] = new ArrayList<Integer>();
       }
       
       for (int i = 0; i < edges.length; i++) {
           adjList[edges[i][0]].add(edges[i][1]);
           adjList[edges[i][1]].add(edges[i][0]);
       }
       
       for (int i = 0; i < n; i++) {
           if (visited[i] == 0) {
               components++;
               dfs(adjList, visited, i);
           }
       }
       return components;
   }
}

//Disjoint Set Union (DSU)
public class Solution {

    private int find(int[] representative, int vertex) {
        if (vertex == representative[vertex]) {
            return vertex;
        }
        
        return representative[vertex] = find(representative, representative[vertex]);
    }
    
    private int combine(int[] representative, int[] size, int vertex1, int vertex2) {
        vertex1 = find(representative, vertex1);
        vertex2 = find(representative, vertex2);
        
        if (vertex1 == vertex2) {
            return 0;
        } else {
            if (size[vertex1] > size[vertex2]) {
                size[vertex1] += size[vertex2];
                representative[vertex2] = vertex1;
            } else {
                size[vertex2] += size[vertex1];
                representative[vertex1] = vertex2;
            }
            return 1;
        }
    }

    public int countComponents(int n, int[][] edges) {
        int[] representative = new int[n];
        int[] size = new int[n];
        
        for (int i = 0; i < n; i++) {
            representative[i] = i;
            size[i] = 1;
        }
        
        int components = n;
        for (int i = 0; i < edges.length; i++) { 
            components -= combine(representative, size, edges[i][0], edges[i][1]);
        }

        return components;
    }
}

class Solution {
    public int countComponents(int n, int[][] edges) {
        UnionFind set = new UnionFind(n);
        for(int[] edge : edges) {
            set.union(edge[0], edge[1]);
        }
        return set.size();
    }
    
    class UnionFind {
        private int[] id, size;
        private int count;
        
        public UnionFind(int len) {
            id = new int[len];
            size = new int[len];
            for(int i = 0; i < len; i++) {
                id[i] = i;
                size[i] = 1;
            }
            count = len;
        }
        
        public int size() {
            return count;
        }
        
        private int root(int i) {
            while(i != id[i]) {
                id[i] = id[id[i]];
                i = id[i];
            }
            return i;
        }
        
        public boolean find(int p, int q) {
            return root(p) == root(q);
        }
        
        public void union(int p, int q) {
            int pi = root(p), qi = root(q);
            if(size[pi] < size[qi]) {
                id[pi] = qi;
                size[qi] += size[pi];
            } else {
                id[qi] = pi;
                size[pi] += size[qi];
            }
            if(pi != qi) count--;
        }
    }
}

//simplified union-find
class Solution {
    public int countComponents(int n, int[][] edges) {
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
        int components = n;
        for (int[] e : edges) {
            int p1 = findParent(parent, e[0]);
            int p2 = findParent(parent, e[1]);
            if (p1 != p2) {
                parent[p1] = p2; // Union 2 component
                components--;
            }
        }
        return components;
    }
    private int findParent(int[] parent, int i) {
        while (i != parent[i]) i = parent[i];
        return i; // Without Path Compression
    }
}