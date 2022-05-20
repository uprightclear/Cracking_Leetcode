//左右区间组合问题
class Solution {
    public int sumSubarrayMins(int[] arr) {
        long res = 0, mod = (int) 1e9 + 7;
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Deque<int[]> s1 = new LinkedList<>();
        Deque<int[]> s2 = new LinkedList<>();
        
        for(int i = 0; i < n; i++) {
            int count = 1;
            while(!s1.isEmpty() && s1.peek()[0] > arr[i]) {
                count += s1.pop()[1];
            }
            s1.push(new int[]{arr[i], count});
            left[i] = count;
        }
        
        for(int i = n - 1; i >= 0; i--) {
            int count = 1;
            while(!s2.isEmpty() && s2.peek()[0] >= arr[i]) {
                count += s2.pop()[1];
            }
            s2.push(new int[]{arr[i], count});
            right[i] = count;
        }
        
        for(int i = 0; i < n; i++) {
            res = (res + (long)arr[i] * left[i] * right[i]) % mod;
        }
        
        return (int)res;
    }
}

class Solution {
    public int sumSubarrayMins(int[] A) {
        Stack<Integer> stack = new Stack<>();
        int[] dp = new int[A.length + 1];
        stack.push(-1);
        int result = 0, M = (int)1e9 + 7;
        for (int i = 0; i < A.length; i++) {
            while (stack.peek() != -1 && A[i] <= A[stack.peek()]) {
                stack.pop();
            }
            dp[i + 1] = (dp[stack.peek() + 1] + (i - stack.peek()) * A[i]) % M;
            stack.push(i);
            result += dp[i + 1];
            result %= M;
        }
        return result;
    }
}