class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        int[] indegree = new int [numCourses];

        //预处理得到入度数组
        for(int[] pre : prerequisites){
            indegree [pre[0]] ++;
        }

        //把入度为0的点放入queue中
        Queue<Integer> queue = new ArrayDeque<>();
        for(int i = 0; i < numCourses ; i++){
            if(indegree[i] == 0){
                queue.offer(i);
            }
        }

        //执行课程
        int i = 0;
        while(!queue.isEmpty()){
            Integer curr = queue.poll();
            res[i++] = curr;

            for(int[] pre : prerequisites){
                if(pre[1] == curr){
                    indegree[pre[0]] --;
                    if(indegree[pre[0]] == 0){
                        queue.offer(pre[0]);
                    }
                }
            }
        }

        return i == numCourses;
    }
}