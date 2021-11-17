class Solution {
    Map<Integer, ArrayList<Pair<Integer, Integer>>> columnTable = new HashMap();
    int minColumn = 0, maxColumn = 0;
  
    private void DFS(TreeNode node, Integer row, Integer column) {
      if (node == null)
        return;
  
      if (!columnTable.containsKey(column)) {
        this.columnTable.put(column, new ArrayList<Pair<Integer, Integer>>());
      }
  
      this.columnTable.get(column).add(new Pair<Integer, Integer>(row, node.val));
      this.minColumn = Math.min(minColumn, column);
      this.maxColumn = Math.max(maxColumn, column);
      // preorder DFS traversal
      this.DFS(node.left, row + 1, column - 1);
      this.DFS(node.right, row + 1, column + 1);
    }
  
    public List<List<Integer>> verticalOrder(TreeNode root) {
      List<List<Integer>> output = new ArrayList();
      if (root == null) {
        return output;
      }
  
      this.DFS(root, 0, 0);
  
      // Retrieve the resuts, by ordering by column and sorting by row
      for (int i = minColumn; i < maxColumn + 1; ++i) {
  
        Collections.sort(columnTable.get(i), new Comparator<Pair<Integer, Integer>>() {
          @Override
          public int compare(Pair<Integer, Integer> p1, Pair<Integer, Integer> p2) {
            return p1.getKey() - p2.getKey();
          }
        });
  
        List<Integer> sortedColumn = new ArrayList();
        for (Pair<Integer, Integer> p : columnTable.get(i)) {
          sortedColumn.add(p.getValue());
        }
        output.add(sortedColumn);
      }
  
      return output;
    }
  }