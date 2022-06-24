class Solution {
    public int calculate(String s) {
        Queue<Character> q = new LinkedList<>();
        for(char c : s.toCharArray()) q.offer(c);
        q.offer('+');
        return cal(q);
    }
    
    public int cal(Queue<Character> q) {
        char sign = '+';
        int num = 0;
        Deque<Integer> stack = new LinkedList<>();
        while(!q.isEmpty()) {
            char c = q.poll();
            if(Character.isDigit(c)) num = num * 10 + (c - '0');
            else if(c == '(') num = cal(q);
            else {
                if(sign == '+') stack.push(num);
                if(sign == '-') stack.push(-num);
                if(sign == '*') stack.push(stack.pop() * num);
                if(sign == '/') stack.push(stack.pop() / num);
                num = 0;
                sign = c;
                if(c == ')') break;
            }
        }
        int sum = 0;
        while(!stack.isEmpty()) sum += stack.pop();
        return sum;
    }
}