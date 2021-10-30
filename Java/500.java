/**
共有三行，这三行分别包含字符：qwertyuiop、asdfghjkl、zxcvbnm
用一个数组保存每个字符的行序号(0~2)，对于一个单词，如果有任意两个元素属于不同的行，则该单词不符合。
 */
class Solution {
    public String[] findWords(String[] words) {
        int[] rowIdx = {1,2,2,1,0,1,1,1,0,1,1,1,2,2,0,0,0,0,1,0,0,2,0,2,0,2};
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < words.length; ++i){
            int row = 0; // 3个bit保存行序号
            for (char c: words[i].toCharArray()){
                if ((int)c <= 'Z') c = (char) (c-'A'+'a');  // 大写转小写
                row |= (1<<rowIdx[c-'a']);
                if (row != 1 && row != 2 && row != 4) break;    // 有任意两个元素属于不同的行
            }
            if (row == 1 || row == 2 || row == 4) ans.add(words[i]);
        }
        String[] res = new String[ans.size()];
        for (int i = 0; i < ans.size(); ++i) res[i] = ans.get(i);
        return res;
    }
}