class Solution {
    public String[] expand(String S) {
        int n = S.length();
        if (n == 0) {
            return new String[]{""};
        }
        if (n == 1) {
            return new String[]{S};
        }
        List<String> res = new ArrayList<>();
        if (S.charAt(0) == '{') {
            int count = 0;
            int i = 0;
            while (i < S.length()) {
                if (S.charAt(i) == '}') {
                    break;
                }
                i++;
            }
            String[] l = S.substring(1, i).split(",");
            String[] r = expand(S.substring(i + 1));
            for (String ll : l) {
                for (String rr : r) {
                    res.add(ll + rr);
                }
            }
        } else {
            String[] r = expand(S.substring(1));
            for (String rr : r) {
                res.add(S.charAt(0) + rr);
            }
        }
        Collections.sort(res);
        return res.toArray(new String[res.size()]);
    }
}