//brute force
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> ans = new LinkedList<>();
        for(int i = 0; i < asteroids.length; i++) {
            add(ans, asteroids[i]);
        }
        int size = ans.size();
        int[] res = new int[size];
        for(int i = 0; i < size; i++) {
            res[i] = ans.removeFirst();
        }
        return res;
    }
    
    public void add(Deque<Integer> ans, int num) {
        if(ans.size() == 0) {
            ans.addLast(num);
        }else if (num * ans.getLast() > 0) {//same direction
            ans.addLast(num);
        }else {//diff directions
            //pre direct left
            if(ans.getLast() < 0) {
                ans.addLast(num);
            //pre direct right
            }else if(Math.abs(num) > ans.getLast()) {//former explode
                ans.removeLast();
                add(ans, num);
            }else if(Math.abs(num) == ans.getLast()){//both explode
                ans.removeLast();
            }
        }
        return;
    }
}


//Stack
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new LinkedList<>();
        for (int ast: asteroids) {
            collision: {
                while (!stack.isEmpty() && ast < 0 && 0 < stack.peek()) {
                    if (stack.peek() < -ast) {
                        stack.pop();
                        continue;
                    } else if (stack.peek() == -ast) {
                        stack.pop();
                    }
                    break collision;
                }
                stack.push(ast);
            }
        }

        int[] ans = new int[stack.size()];
        for (int t = ans.length - 1; t >= 0; --t) {
            ans[t] = stack.pop();
        }
        return ans;
    }
}