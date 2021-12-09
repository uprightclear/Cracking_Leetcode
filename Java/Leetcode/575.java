class Solution {
    public int distributeCandies(int[] candyType) {
        int len = candyType.length;
        Set<Integer> type = new HashSet<>();
        for(int candy : candyType) {
            type.add(candy);
        }
        if(type.size() < len / 2) return type.size();
        else return len / 2;
    }
}