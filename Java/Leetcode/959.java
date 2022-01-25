//  \0 /
// 3 \/1
//   /\
//  /2 \
class Solution {
    int count, n;
    int[] f;
    public int regionsBySlashes(String[] grid) {
        n = grid.length;
        f = new int[n * n * 4];  //build an array to store all parents of all triangles
        count = n * n * 4;        //total number of polygons
        for (int i = 0; i < n * n * 4; ++i)    //initialize the parent array
            f[i] = i;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i > 0) union(g(i - 1, j, 2), g(i, j, 0));   // merge triangles 2 and 0 from two squares vertically
                if (j > 0) union(g(i, j - 1, 1), g(i, j, 3)); // merge trianges 1 and 3 from two squares horizontally. These triangles are supposed to be contiguous originally
                if (grid[i].charAt(j) != '/') {                      // if it is "\\" or empty, apply common operations
                    union(g(i, j, 0), g(i, j, 1));
                    union(g(i, j, 2), g(i, j, 3));
                }
                if (grid[i].charAt(j) != '\\') {              // if it is "/" or empty, apply common operations.
                    union(g(i, j, 0), g(i, j, 3));         // These two if statements solve the repetition issue caused by traditional three if statements
                    union(g(i, j, 2), g(i, j, 1));
                }
            }
        }
        return count;               //return number of polygons in the graph
    }

    public int find(int x) {
        if (x != f[x]) {
            f[x] = find(f[x]);  //path compression
        }
        return f[x];
    }
    public void union(int x, int y) {     //merge two polygons to a bigger polygon will decrease number of polygons by 1
        x = find(x); y = find(y);
        if (x != y) {
            f[x] = y;
            count--;
        }
    }
    public int g(int i, int j, int k) {    //find the corresponding position for current triangle. Thinks this 1D array as a 2D array and each element is an array of size 4.
        return (i * n + j) * 4 + k;
    }
}