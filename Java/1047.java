class Solution {
    public String removeDuplicates(String s) {
        LinkedList<Character> list = new LinkedList<>();
        for(char c : s.toCharArray()) {
            if(list.isEmpty()) {
                list.addLast(c);
            } else {
                if(list.getLast().equals(c)) list.removeLast();
                else list.addLast(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(char c : list) sb.append(c);
        return sb.toString();
    }
}

//use StringBuilder directly
class Solution {
    public String removeDuplicates(String S) {
      StringBuilder sb = new StringBuilder();
      int sbLength = 0;
      for(char character : S.toCharArray()) {
        if (sbLength != 0 && character == sb.charAt(sbLength - 1))
          sb.deleteCharAt(sbLength-- - 1);
        else {
          sb.append(character);
          sbLength++;
        }
      }
      return sb.toString();
    }
  }