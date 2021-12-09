class Solution {
  public int minMeetingRooms(int[][] intervals) {
      PriorityQueue<Integer> allocator = new PriorityQueue<>();
      Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
      
      allocator.add(intervals[0][1]);
      
      for(int i = 1; i < intervals.length; i++) {
          if(intervals[i][0] >= allocator.peek()) {
              allocator.poll();
          }
          allocator.add(intervals[i][1]);
      }
      return allocator.size();
  }
}