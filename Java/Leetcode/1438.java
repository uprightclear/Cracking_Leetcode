//TLE
class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int ans = 1;
        int n = nums.length;
        if(n == 1) return ans;
        for(int i = 2; i <= n; i++) {
            for(int j = 0; j <= n - i; j++) {
                int max = nums[j], min = nums[j];
                for(int k = 1; k < i; k++) {
                    max = Math.max(max, nums[j + k]);
                    min = Math.min(min, nums[j + k]);
                    if((max - min) > limit) break;
                }
                if((max - min) <= limit) {
                    ans = Math.max(ans, i);
                    break;
                }
            }
        }
        return ans;
    }
}

//sliding window + TreeMap
class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int start = 0, end;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(end = 0; end < nums.length; end++) {
            map.put(nums[end], map.getOrDefault(nums[end], 0) + 1);
            if(map.lastEntry().getKey() - map.firstEntry().getKey() > limit) {
                map.put(nums[start], map.get(nums[start]) - 1);
                if(map.get(nums[start]) == 0) map.remove(nums[start]);
                start++;
            }
        }
        return end - start;
    }
}


public int longestSubarray(int[] nums, int limit) {
    Deque<Integer> maxQ = new LinkedList<>();
    Deque<Integer> minQ = new LinkedList<>();
    
    int start = 0;
    int size = 0;
    
    for (int end = 0; end < nums.length; end++) {
        
        while (!maxQ.isEmpty() && maxQ.peekLast() < nums[end]) {
            maxQ.pollLast();
        } 
        
        while (!minQ.isEmpty() && minQ.peekLast() > nums[end]) {
            minQ.pollLast();
        }
        
        maxQ.addLast(nums[end]);
        minQ.addLast(nums[end]);
        
        if (maxQ.peekFirst() - minQ.peekFirst() > limit) {
            if (nums[start] == maxQ.peekFirst()) {
                maxQ.pollFirst();
            }
            if (nums[start] == minQ.peekFirst()) {
                minQ.pollFirst();
            }
            start++;
        }
        
        size = Math.max(size, end - start + 1);
    }
    
    return size;
}