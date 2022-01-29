class Solution {
    public int[] findOriginalArray(int[] changed) {
        int len = changed.length;
        if(len % 2 == 1) return new int[]{};
        Map<Integer, Integer> cnt = new TreeMap<>();
        for(int change : changed) cnt.put(change, cnt.getOrDefault(change, 0) + 1);
        int[] ans = new int[len / 2];
        int index = 0;
        for(int num : cnt.keySet()) {
            if(cnt.get(num) == 0) continue;
            int want = num * 2;
            if(cnt.get(num) > cnt.getOrDefault(want, 0)) return new int[]{};
            cnt.put(want, cnt.get(want) - cnt.get(num));
            int count = cnt.get(num);
            while(count-- > 0) ans[index++] = num;
        }
        return ans;
    }
}