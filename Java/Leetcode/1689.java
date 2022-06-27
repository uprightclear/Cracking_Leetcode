class Solution {
    public int minPartitions(String n) {
        int maximum = 0;
        for (int i = 0; i < n.length(); i++) {
            maximum = Math.max(maximum, n.charAt(i) - '0');
        }
        return maximum;
    }
}