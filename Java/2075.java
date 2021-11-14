class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        int cols = encodedText.length() / rows;
        char[][] mtx = new char[rows][cols];
        
        for(int i = 0; i < encodedText.length(); i++) {
            int x = i / cols;
            int y = i % cols;
            mtx[x][y] = encodedText.charAt(i);
        }
        
        StringBuilder sb = new StringBuilder();
        for(int startY = 0; startY < cols; startY++) {
            for(int x = 0, y = startY; x < rows && y < cols; x++, y++) {
                sb.append(mtx[x][y]);
            }
        }
        
        while(sb.length() > 0 && sb.charAt(sb.length() - 1) == ' ') {
            sb.deleteCharAt(sb.length() - 1);
        }
        
        return sb.toString();
    }
}