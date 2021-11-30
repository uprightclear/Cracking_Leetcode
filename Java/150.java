class Solution {
    int seen = -1;
    public int evalRPN(String[] tokens) {
        return eval(tokens, tokens.length - 1);
    }
    
    private int eval(String[] tokens, int end){
        String op = tokens[end];
        if(!isOp(op)){
            seen = end;
            return Integer.parseInt(op);
        } 
        int b = eval(tokens, end-1);
        int a = eval(tokens, seen-1);
        int result;
        if(op.equals("*")) result = a * b;
        else if(op.equals("+")) result = a + b;
        else if(op.equals("-")) result = a - b;
        else result = a / b;
        //if(seen > end) seen = end;
        return result;
    }
    
    private boolean isOp(String s){
        if(s.equals("*")) return true;
        else if(s.equals("/")) return true;
        else if(s.equals("+")) return true;
        else if(s.equals("-")) return true;
        else return false;
    }
}


class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<>();
        for(String token : tokens) {
            if(token.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (token.equals("-")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a - b);
            } else if (token.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (token.equals("/")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a / b);
            } else {
                stack.push(Integer.valueOf(token));
            }
        }
        return stack.pop();
    }
}