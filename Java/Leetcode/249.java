class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> ans = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strings) {
            if(str.length() == 1) {
                map.putIfAbsent("a", new ArrayList<String>());
                map.get("a").add(str);
                continue;
            }
            StringBuilder sb = new StringBuilder("a");
            for(int i = 1; i < str.length(); i++) {
                int diff = str.charAt(i) - str.charAt(i - 1);
                if(diff < 0) diff += 26;
                sb.append(diff + 'a');
            }
            String key = sb.toString();
            map.putIfAbsent(key, new ArrayList<String>());
            map.get(key).add(str);
        }
        
        for(Map.Entry<String, List<String>> entry : map.entrySet()) {
            ans.add(entry.getValue());
        }
        
        return ans;
    }
}