class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] dic = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> ans = new HashSet<>();
        
        for(String word : words){
            StringBuilder sb = new StringBuilder(); 
            for(char c : word.toCharArray()){
                sb.append(dic[c - 'a']);
            }
            ans.add(sb.toString());
        }
        return ans.size();
    }
}