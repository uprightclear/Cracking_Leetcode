//重构字符串
class Solution {
    public boolean backspaceCompare(String s, String t) {
        String news = build(s);
        String newt = build(t);
        return news.equals(newt);
    }
    
    private String build(String s) {
        Deque<Character> stack = new LinkedList<>();
        for(int i = 0; i < s.length(); i++) {
            if(!stack.isEmpty() && s.charAt(i) == '#') {
                stack.pop();
            } else if(s.charAt(i) != '#'){
                stack.push(s.charAt(i));
            }
        }
        //"ab#c"
        //return [c, a]
        return stack.toString();
        //return [a, c]
        return String.valueOf(stack);
    }
}

//2 pointers
class Solution {
    public boolean backspaceCompare(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1;
        int skipS = 0, skipT = 0;

        while (i >= 0 || j >= 0) {
            while (i >= 0) {
                if (S.charAt(i) == '#') {
                    skipS++;
                    i--;
                } else if (skipS > 0) {
                    skipS--;
                    i--;
                } else {
                    break;
                }
            }
            while (j >= 0) {
                if (T.charAt(j) == '#') {
                    skipT++;
                    j--;
                } else if (skipT > 0) {
                    skipT--;
                    j--;
                } else {
                    break;
                }
            }
            if (i >= 0 && j >= 0) {
                if (S.charAt(i) != T.charAt(j)) {
                    return false;
                }
            } else {
                if (i >= 0 || j >= 0) {
                    return false;
                }
            }
            i--;
            j--;
        }
        return true;
    }
}