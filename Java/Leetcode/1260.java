class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {

       int n = grid.length;
       int m = grid[0].length;//矩阵的长宽
       LinkedList<Integer> linkedList = new LinkedList<>();
       int x = 0;
       for (int[] ints : grid) {
           for (int j = 0; j < m; j++) {
               linkedList.add(ints[j]);
           }
       }//对矩阵进行扁平化操作，全塞进链表


       x = linkedList.size()-k%linkedList.size();//计算多次转移后，重构矩阵的下标
       List<List<Integer>> ans = new ArrayList<>();
       while (!linkedList.isEmpty()){
          List<Integer> list = new ArrayList<>();
          for (int i =0;i<m;i++){
              if (x>=linkedList.size()||x<0)x=0;//防止下标越界
              list.add(linkedList.get(x));
              linkedList.remove(x);
          }//根据矩阵的长宽来重组答案
             ans.add(list);
      }
           return ans;

   }
}