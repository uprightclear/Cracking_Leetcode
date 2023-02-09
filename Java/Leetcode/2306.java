class Solution {
    public long distinctNames(String[] ideas) {
        Map<String, Integer> group = new HashMap<>();
        for (String s : ideas) {
            String t = s.substring(1);
            group.put(t, group.getOrDefault(t, 0) | 1 << (s.charAt(0) - 'a'));
        }
        long ans = 0L;
        //cnt[i][j] 表示组中首字母不包含 i 但包含 j 的组的个数
        int[][] cnt = new int[26][26];
        for (int mask : group.values())
            for (int i = 0; i < 26; i++)
                if ((mask >> i & 1) == 0) {//首字母不包含i
                    for (int j = 0; j < 26; j++)
                        if ((mask >> j & 1) > 0) ++cnt[i][j];
                } else {//首字母含i
                    for (int j = 0; j < 26; j++)
                        //不含j
                        if ((mask >> j & 1) == 0) ans += cnt[i][j];
                }
        return ans * 2;
    }
}