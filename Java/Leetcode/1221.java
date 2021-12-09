//模拟
class Solution {
    public int balancedStringSplit(String s) {
        int ans = 0, d = 0;
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (ch == 'L') {
                ++d;
            } else {
                --d;
            }
            if (d == 0) {
                ++ans;
            }
        }
        return ans;
    }
}

//stack
public int balancedStringSplit(String s) {
    Stack<Character> stack = new Stack<Character>();
    int count = 0;
    for(int i = 0; i < s.length(); i++){
        char c = s.charAt(i);
        if(stack.isEmpty() || c == stack.peek()) {
            stack.push(c);
        }
        else{
            stack.pop();
        }
        if(stack.isEmpty()) {
            count++;
        }
    }
    return count;
}