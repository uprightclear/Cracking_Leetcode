class Solution {
    public int findTheWinner(int n, int k) {
        Queue<Integer> queue = new ArrayDeque<Integer>();
        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }
        while (queue.size() > 1) {
            for (int i = 1; i < k; i++) {
                queue.offer(queue.poll());
            }
            queue.poll();
        }
        return queue.peek();
    }
}

//https://leetcode-cn.com/problems/find-the-winner-of-the-circular-game/solution/java-yue-se-fu-huan-xiang-jie-bao-zheng-v3pwo/
class Solution {
    public int findTheWinner(int n, int k) {
        if(n == 1) return 1;
        int ans = findTheWinner(n - 1, k) + k;
        return ans % n == 0? n: (ans % n);
    }
}