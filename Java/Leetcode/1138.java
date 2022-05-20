class Solution {
    public String alphabetBoardPath(String target) {
      int x = 0, y = 0;
      StringBuilder sb = new StringBuilder();
      for (char ch : target.toCharArray()) {
        int x1 = (ch - 'a') % 5, y1 = (ch - 'a') / 5;
        sb.append(String.join("", Collections.nCopies(Math.max(0, y - y1), "U")) +
          String.join("", Collections.nCopies(Math.max(0, x1 - x), "R")) +
          String.join("", Collections.nCopies(Math.max(0, x - x1), "L")) +
          String.join("", Collections.nCopies(Math.max(0, y1 - y), "D")) + "!");
        x = x1; y = y1;
      }
      return sb.toString();
    }
}