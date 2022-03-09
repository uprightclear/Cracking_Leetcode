class Solution {
    public int calculate(String s) {
        Deque<Integer> ops = new LinkedList<Integer>();
        ops.push(1);
        int sign = 1;

        int ret = 0;
        int n = s.length();
        int i = 0;
        while (i < n) {
            if (s.charAt(i) == ' ') {
                i++;
            } else if (s.charAt(i) == '+') {
                sign = ops.peek();
                i++;
            } else if (s.charAt(i) == '-') {
                sign = -ops.peek();
                i++;
            } else if (s.charAt(i) == '(') {
                ops.push(sign);
                i++;
            } else if (s.charAt(i) == ')') {
                ops.pop();
                i++;
            } else {
                long num = 0;
                while (i < n && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                ret += sign * num;
            }
        }
        return ret;
    }
}

class Solution {
    public int calculate(String s) {
        s = s.trim();
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        int sign = 1;
        int res = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)) num = num * 10 + s.charAt(i) - '0';
            else {
                if(c == '+') {
                    res += sign * num;
                    sign = 1;
                    num = 0;
                } else if(c == '-') {
                    res += sign * num;
                    sign = -1;
                    num = 0;
                } else if(c == '(') {
                    stack.push(res);
                    stack.push(sign);
                    sign = 1;
                    res = 0;
                } else if(c == ')'){
                    res += sign * num;
                    res *= stack.pop();
                    res += stack.pop();
                    num = 0;
                }
            }
        }
        return res + sign * num;
    }
}