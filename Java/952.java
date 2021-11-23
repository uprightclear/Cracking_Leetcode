//union find
class Solution {
    public int largestComponentSize(int[] A) {

        int maxValue = Arrays.stream(A).reduce(A[0], (x, y) -> x > y ? x : y);
        DisjointSetUnion dsu = new DisjointSetUnion(maxValue);
        // attribute each element to all the groups that lead by its factors.
        for (int num : A) {
            for (int factor=2; factor < (int)(Math.sqrt(num))+1; ++ factor)
                if (num % factor == 0) {
                    dsu.union(num, factor);
                    dsu.union(num, num / factor);
                }
        }

        // count the size of group one by one
        int maxGroupSize = 0;
        HashMap<Integer, Integer> groupCount = new HashMap<>();
        for (int num : A) {
            Integer groupId = dsu.find(num);
            Integer count = groupCount.getOrDefault(groupId, 0);
            groupCount.put(groupId, count+1);
            maxGroupSize = Math.max(maxGroupSize, count+1);
        }

        return maxGroupSize;
    }
}


class DisjointSetUnion {
    private int[] parent;
    private int[] size;

    public DisjointSetUnion(int size) {
        this.parent = new int[size + 1];
        this.size = new int[size + 1];
        for (int i = 0; i < size + 1; ++i) {
            this.parent[i] = i;
            this.size[i] = 1;
        }
    }

    /** return the component id that the element x belongs to. */
    public int find(int x) {
        if (this.parent[x] != x)
            this.parent[x] = this.find(this.parent[x]);
        return this.parent[x];
    }

    /**
     * merge the two components that x, y belongs to respectively,
     * and return the merged component id as the result.
     */
    public int union(int x, int y) {
        int px = this.find(x);
        int py = this.find(y);

        // the two nodes share the same group
        if (px == py)
            return px;

        // otherwise, connect the two sets (components)
        if (this.size[px] > this.size[py]) {
            // add the node to the union with less members.
            // keeping px as the index of the smaller component
            int temp = px;
            px = py;
            py = temp;
        }

        // add the smaller component to the larger one
        this.parent[px] = py;
        this.size[py] += this.size[px];
        return py;
    }
}