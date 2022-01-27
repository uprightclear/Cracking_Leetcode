class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties, (a, b) -> (a[0] == b[0]) ? (b[1] - a[1]) : a[0] - b[0]);
        int max = properties[properties.length - 1][1];
        int count = 0;
        for(int i = properties.length - 2; i >= 0; i--){
            if(properties[i][1] < max) {
                count++;
            }
            max = Math.max(properties[i][1], max);
        }

        return count; 
    }
}