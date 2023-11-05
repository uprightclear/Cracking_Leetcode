class Solution {
    public int getWinner(int[] arr, int k) {
        int maxElement = arr[0];
        Queue<Integer> queue = new LinkedList();
        for (int i = 1; i < arr.length; i++) {
            maxElement = Math.max(maxElement, arr[i]);
            queue.offer(arr[i]);
        }
        
        int curr = arr[0];
        int winstreak = 0;
        
        while (!queue.isEmpty()) {
            int opponent = queue.poll();
            
            if (curr > opponent) {
                queue.offer(opponent);
                winstreak++;
            } else {
                queue.offer(curr);
                curr = opponent;
                winstreak = 1;
            }
            
            if (winstreak == k || curr == maxElement) {
                return curr;
            }
        }
        
        return -1;
    }
}