class Solution {
    public int minAddToMakeValid(String s) {
        int ans = 0;
        Deque<Character> stack = new LinkedList<Character>();
        for(char c : s.toCharArray()) {
            if(c == '(') {
                stack.push(c);  
            }else if(c == ')' && !stack.isEmpty()) {
                stack.pop();
            }else {
                ans++;
            }
        }
        return ans + stack.size();
    }
}