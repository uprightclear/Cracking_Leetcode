class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for(int i = 0; i < target.length; i++) {
            cnt.put(target[i], cnt.getOrDefault(target[i], 0) + 1);
            cnt.put(arr[i], cnt.getOrDefault(arr[i], 0) - 1);
        }
        for(int i : cnt.keySet()) {
            if(cnt.get(i) != 0) return false;
        }
        return true;
    }
}