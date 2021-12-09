class Solution {
    public int calculate(String s) {
        int len;
        if(s == null || (len = s.length()) == 0) return 0;
        Stack<Integer> stack = new Stack<Integer>();
        int num = 0;
        char sign = '+';
        for(int i  =0; i < len; i++){
            if(Character.isDigit(s.charAt(i))){
                num = num * 10 + s.charAt(i) - '0';
            }
            //i == len - 1 : make sure to add the last number, in this situation we don't care about the next sign.
            if((!Character.isDigit(s.charAt(i)) && ' ' != s.charAt(i)) || i == len - 1){
                if(sign == '-'){
                    stack.push(-num);
                }
                if(sign == '+'){
                    stack.push(num);
                }
                if(sign == '*'){
                    stack.push(stack.pop() * num);
                }
                if(sign == '/'){
                    stack.push(stack.pop() / num);
                }
                sign = s.charAt(i);
                num = 0;
            }
        }

        int ans = 0;
        for(int i : stack){
            ans += i;
        }
        return ans;
    }
}