//BFS
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        //for(String w : wordList) dict.add(w);

        if(!dict.contains(endWord)) return 0;

        Queue<String> q = new ArrayDeque<>();
        q.offer(beginWord);

        int l = beginWord.length();
        int step = 0;

        while(!q.isEmpty()){
            step++;
            for(int s = q.size(); s > 0; s--){
                String w = q.poll();
                char[] chs = w.toCharArray();
                for(int i = 0; i < l; i++){
                    char ch = chs[i];
                    for(char c = 'a'; c <= 'z'; c++){
                        if(ch == c) continue;
                        chs[i] = c;
                        String t = new String(chs);
                        if(t.equals(endWord)) return step + 1;
                        if(!dict.contains(t)) continue;
                        dict.remove(t);
                        q.offer(t);
                    }
                    chs[i] = ch;
                }
            }
        }
        return 0;
    }
}

  //biditectional BFS
  class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>();
        for(String word : wordList) dict.add(word);

        //特殊判断
        if(!dict.contains(endWord)) return 0;

        Set<String> q1 = new HashSet<>();
        Set<String> q2 = new HashSet<>();
        q1.add(beginWord);
        q2.add(endWord);

        int l = beginWord.length();
        int step = 0;

        while(!q1.isEmpty() && !q2.isEmpty()){
            step++;
            if(q1.size() > q2.size()){
                Set<String> tmp = q1;
                q1 = q2;
                q2 = tmp;
            }

            Set<String> q = new HashSet<>();
            for(String w : q1){
                char[] chs = w.toCharArray();
                for(int i = 0; i < l; i++){
                    char ch = chs[i];
                    for(char c = 'a'; c <= 'z'; c++){
                        if(ch == c) continue;
                        chs[i] = c;
                        String t = new String(chs);
                        if(q2.contains(t)) return step + 1;
                        if(!dict.contains(t)) continue;
                        dict.remove(t);
                        q.add(t);
                    }
                    chs[i] = ch;
                }
            }
            q1 = q;
        }
        return 0;
    }
}