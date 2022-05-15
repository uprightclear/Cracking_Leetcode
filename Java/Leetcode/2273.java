class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> ans = new ArrayList<>();
        ans.add(words[0]);
        for(int i = 1; i < words.length; i++) {
            if(!isAnagram(words[i], words[i - 1])) ans.add(words[i]);
        }
        return ans;
    }
    
    public boolean isAnagram(String s1, String s2) {
        if(s1.length() != s2.length()) return false;
        char[] a1 = s1.toCharArray();
        char[] a2 = s2.toCharArray();
        Arrays.sort(a1);
        Arrays.sort(a2);
        return Arrays.equals(a1, a2);
    }
}