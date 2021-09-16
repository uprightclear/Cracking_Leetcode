class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> res = new HashSet<>();
        Set<String> dict = new HashSet<>();
        for(int i = 10; i <= s.length(); i++){
            if(dict.contains(s.substring(i - 10, i))){
                res.add(s.substring(i - 10, i));
            }else{
                dict.add(s.substring(i - 10, i));
            }
        }
        return new ArrayList(res);
    }
}