class Solution {

    public double maxAverageRatio(int[][] classes, int extraStudents) {

        int n = classes.length;
        // 定义优先队列，优先级按照增加 1 名学生之后能够产生的最大贡献来排序
        PriorityQueue<double[]> queue = new PriorityQueue<double[]>((o1, o2) -> {

            double x = ((o2[0] + 1) / (o2[1] + 1) - o2[0] / o2[1]);
            double y = ((o1[0] + 1) / (o1[1] + 1) - o1[0] / o1[1]);
            if (x > y) return 1;
            if (x < y) return -1;
            return 0;
        });
        
		// 转化为 double，方便小数计算
        for (int[] c : classes) {

            queue.offer(new double[]{c[0], c[1]});
        }
        
		// 分配学生，每次分配 1 名
        while (extraStudents > 0) {
            
            double[] maxClass = queue.poll(); //取出能够产生最大影响的班级
            maxClass[0] += 1.0; //通过的人数
            maxClass[1] += 1.0; //班级总人数

            queue.offer(maxClass); //将更新后的重新加入队列中
            extraStudents--;
        }
        
		// 计算最终结果
        double res = 0;
        while (!queue.isEmpty()) {

            double[] c = queue.poll();
            res += (c[0] / c[1]);
        }
        return res / n;
    }
}