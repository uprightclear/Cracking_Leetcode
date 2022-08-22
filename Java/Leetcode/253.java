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



class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals.length == 0) return 0;
        
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        
        for(int i = 0; i < intervals.length; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        
        Arrays.sort(end);
        Arrays.sort(start);
        
        int startPointer = 0, endPointer = 0;
        int usedRooms = 0;
        
        while(startPointer < intervals.length) {
            if(start[startPointer] >= end[endPointer]) {
                usedRooms -= 1;
                endPointer += 1;
            }
            
            usedRooms += 1;
            startPointer += 1;
        }
        return usedRooms;
    }
}