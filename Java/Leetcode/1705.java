/**
贪心：每天应该吃剩余保质期最短的苹果。
用一个优先队列，保存(腐烂日期, 腐烂的数量)，每次取队首就是剩余保质期最短的。到腐烂日期或者腐烂数量归零（提前吃完了）的节点出队。
 */
class Solution {
    public int eatenApples(int[] apples, int[] days) {
        int ans = 0;
        Queue<int[]> queue = new PriorityQueue<>((x1, x2) -> x1[0] - x2[0]);
        int d = 0;
        while (d < apples.length || !queue.isEmpty()){
            if (d < apples.length && apples[d] > 0) queue.add(new int[]{d + days[d], apples[d]});       // 新结出的苹果入队
            while (!queue.isEmpty() && (queue.peek()[0] <= d || queue.peek()[1] == 0)) queue.poll();  // 到腐烂日期或者腐烂数量归零
            if (!queue.isEmpty()) {     // 吃苹果
                ++ans;
                --queue.peek()[1];
            }
            ++d;
        }
        return ans;
    }
}