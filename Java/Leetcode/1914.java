class Solution {
    public int[][] rotateGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        
        int layerLen = m * n - (m - 2) *(n - 2); // len of layer m*n(size of suare) -  (m-2)*(n-2) size of inner square
        int[] arr = new int[layerLen];        // arr is outer layer of grid as a linear array
        rotateOuterGrid(grid, k, 0, m - 1, 0, n - 1, arr); // rotating grid inplace
        return grid;
        
    }
    
    public void rotateOuterGrid(int[][] grid, int k, int a, int b, int c, int d, int[] arr){
        if(a >= b || c >= d)  // return if most inner layer is completed
            return;
        int layerLen = (b - a + 1) * (d - c + 1) - (b - a - 1) * (d - c - 1);  // calculating the size of current outer layer
        int tk = k % layerLen;                                    // new k for current layer
        int p =0;                              // pointer
        
        int[] arr2 = new int[tk];              // temp array for 1st tk elements
        
        // adding the current outer layer to linear array arr
        int top = a, bottom = b, left = c, right = d;
        for(int i = left; i <= right; i++){
                arr[p++] = grid[top][i];
        }
        top++;
        for(int i = top; i <= bottom; i++){
                arr[p++] = grid[i][right];
        }
        right--;
        for(int i = right; i >=left; i--){
                arr[p++] = grid[bottom][i];
        }
        bottom--;
        for(int i = bottom; i >= top; i--){
                arr[p++] = grid[i][left];
        }
        left++;
        
        
        // filling first tk elements to temp array
        for(int i = 0; i < tk; i++){
            arr2[i] = arr[i];
        }
        
        // shifting forward arr by tk elements and adding temp array arr2 in the back of arr
        int j =0;
        for( j = 0; j + tk < layerLen; j++){
            arr[j] = arr[j+tk];
        }
        for(int i = 0; i < tk; i++){
            arr[j++] = arr2[i];
        }
        
        // filling the current outer layer of grid from linear array arr
        p = 0;
        top = a; bottom = b; left = c; right = d;
        for(int i = left; i <= right; i++){
                grid[top][i] = arr[p++];
        }
        top++;
        for(int i = top; i <= bottom; i++){
                grid[i][right] = arr[p++];
        }
        right--;
        for(int i =right; i >= left; i--){
                grid[bottom][i] = arr[p++];
        }
        bottom--;
        for(int i = bottom; i >= top; i--){
                grid[i][left] = arr[p++];
        }
        left++;
        
        // doing the same for inner layers
        rotateOuterGrid(grid, k, top, bottom, left, right, arr);
        
    }
}