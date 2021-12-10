class Solution {
    public String removeDuplicateLetters(String s) {
        Deque<Character> stack = new LinkedList<>();
        Set<Character> seen = new HashSet<>();
        Map<Character, Integer> last_occurance = new HashMap<>();
        for(int i = 0; i < s.length(); i++) last_occurance.put(s.charAt(i), i);
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(!seen.contains(c)) {
                while(!stack.isEmpty() && c < stack.peek() && last_occurance.get(stack.peek()) > i) seen.remove(stack.pop());
                seen.add(c);
                stack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(char c : stack) sb.append(c);
        sb.reverse();
        return sb.toString();
    }
}