class Solution {
    public long minimumHealth(int[] damage, int armor) {
        long sum = 0, max = 0;
        for(int d : damage) {
            sum += d;
            max = Math.max(max, d);
        }
        if(max <= armor) return sum - max + 1;
        return sum - armor + 1;
    }
}