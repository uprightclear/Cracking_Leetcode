class Solution {
    public int minProcessingTime(List<Integer> processorTime, List<Integer> tasks) {
        int ans = 0, index = 0;
        Collections.sort(tasks);
        Collections.reverse(tasks);
        Collections.sort(processorTime);
        int n = processorTime.size();
        for(int i = 0; i < tasks.size(); i += 4) {
            int begin = processorTime.get(index);
            ans = Math.max(ans, begin + tasks.get(i));
            index++;
        }
        return ans;
    }
}