class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int ans = 0;
        Arrays.sort(boxTypes, new Comparator<int[]>(){
            public int compare(int[] a, int[] b) {
                return b[1] - a[1];
            }
        });
        
        for(int i = 0; i < boxTypes.length; i++) {
            if(truckSize >= boxTypes[i][0]) {
                truckSize -= boxTypes[i][0];
                ans += boxTypes[i][0] * boxTypes[i][1];
            }else {
                ans += truckSize * boxTypes[i][1];
                truckSize = 0;
            }
            if(truckSize == 0) break;
        }
        return ans;
    }
}

//PriorityQueue
class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b)->b[1] - a[1]);
        queue.addAll(Arrays.asList(boxTypes));
        int unitCount = 0;
        while (!queue.isEmpty()) {
            int[] top = queue.poll();
            int boxCount = Math.min(truckSize, top[0]);
            unitCount += boxCount * top[1];
            truckSize -= boxCount;
            if(truckSize == 0)
                break;
        }
        return unitCount;
    }
}