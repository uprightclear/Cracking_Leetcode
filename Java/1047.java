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