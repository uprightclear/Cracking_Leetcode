//DFS
class Solution {

    //        x-1,y
    // x,y-1  x,y    x,y+1
    //        x+1,y
    private int[][] direction = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    // 盘面上有多少行
    private int m;
    // 盘面上有多少列
    private int n;
    private String word;
    private char[][] board;
    private Set<String> res;

    public List<String> findWords(char[][] board, String[] words) {
        res = new HashSet<>();
        m = board.length;
        if (m == 0) {
            return new ArrayList<String>(res);
        }
        n = board[0].length;
        this.board = board;

        for(String word : words){
            boolean[][] marked = new boolean[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    dfs(i, j, word, marked, 0);
                }
            }
        }
        return new ArrayList<String>(res);
    }

    private void dfs(int i, int j, String word, boolean[][] marked, int start) {
        if (start == word.length() - 1) {
            if(board[i][j] == word.charAt(start)){
                res.add(word);  
                return;
            }
        }
        if (board[i][j] == word.charAt(start)) {
            marked[i][j] = true;
            for (int k = 0; k < 4; k++) {
                int newX = i + direction[k][0];
                int newY = j + direction[k][1];
                if (inArea(newX, newY) && !marked[newX][newY]) {
                    dfs(newX, newY, word, marked, start + 1);
                }
            }
            marked[i][j] = false;
        }
        return;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}



//TrieNode
class TrieNode {
    HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
    String word = null;
    public TrieNode() {}
}
  
class Solution {
    char[][] _board = null;
    ArrayList<String> _result = new ArrayList<String>();
  
    public List<String> findWords(char[][] board, String[] words) {
  
        // Step 1). Construct the Trie
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;
  
            for (Character letter : word.toCharArray()) {
                if (node.children.containsKey(letter)) {
                    node = node.children.get(letter);
                } else {
                    TrieNode newNode = new TrieNode();
                    node.children.put(letter, newNode);
                    node = newNode;
                }
            }
            node.word = word;  // store words in Trie
        }
  
        this._board = board;
        // Step 2). Backtracking starting for each cell in the board
        for (int row = 0; row < board.length; ++row) {
            for (int col = 0; col < board[row].length; ++col) {
                if (root.children.containsKey(board[row][col])) {
                    backtracking(row, col, root);
                }
            }
        }
  
        return this._result;
    }
    
    private void backtracking(int row, int col, TrieNode parent) {
        Character letter = this._board[row][col];
        TrieNode currNode = parent.children.get(letter);
  
        // check if there is any match
        if (currNode.word != null) {
            this._result.add(currNode.word);
            currNode.word = null;
        }
  
        // mark the current letter before the EXPLORATION
        this._board[row][col] = '#';
  
        // explore neighbor cells in around-clock directions: up, right, down, left
        int[] rowOffset = {-1, 0, 1, 0};
        int[] colOffset = {0, 1, 0, -1};
        for (int i = 0; i < 4; ++i) {
            int newRow = row + rowOffset[i];
            int newCol = col + colOffset[i];
            if (newRow < 0 || newRow >= this._board.length || newCol < 0 || newCol >= this._board[0].length) {
                continue;
            }
            if (currNode.children.containsKey(this._board[newRow][newCol])) {
                backtracking(newRow, newCol, currNode);
            }
        }
  
        // End of EXPLORATION, restore the original letter in the board.
        this._board[row][col] = letter;
  
        // Optimization: incrementally remove the leaf nodes
        if (currNode.children.isEmpty()) {
            parent.children.remove(letter);
        }
    }

}