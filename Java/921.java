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

//Balance
class Solution {
    public int minAddToMakeValid(String S) {
        int ans = 0, bal = 0;
        for (int i = 0; i < S.length(); ++i) {
            bal += S.charAt(i) == '(' ? 1 : -1;
            // It is guaranteed bal >= -1
            if (bal == -1) {
                ans++;
                bal++;
            }
        }

        return ans + bal;
    }
}