class Solution {
    public int thirdMax(int[] nums) {
        TreeSet<Integer> s = new TreeSet<Integer>();
        for (int num : nums) {
            s.add(num);
            if (s.size() > 3) {
                s.remove(s.first());
            }
        }
        return s.size() == 3 ? s.first() : s.last();
    }
}



class Solution {
    public int thirdMax(int[] nums) {
        PriorityQueue<Integer> minpq = new PriorityQueue<>();
        Set<Integer> set = new HashSet<>();
        for (int num: nums) {
            if ((minpq.size() < 3 || minpq.peek() < num) && (!set.contains(num))) { 
                if (minpq.size() == 3) {
                    minpq.poll();
                }
                minpq.offer(num);
                set.add(num);
            }
        }
        if (minpq.size() == 2) {
            minpq.poll();
        }
        return minpq.peek();
    }
}