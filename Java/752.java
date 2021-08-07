//BFS
class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> dead =  new HashSet<>();
        for(String word : deadends) dead.add(word);
        String start = "0000";
        //special adjugement
        if(start.equals(target)) return 0;
        if(dead.contains(start)) return -1;

        Queue<String> q = new ArrayDeque<>();
        q.offer(start);
        Set<String> visited = new HashSet<>();
        visited.add(start);
        int step = 0;

        while(!q.isEmpty()){
            step++;
            for(int s = q.size(); s > 0; s--){
                String w = q.poll();
                for(int i = 0; i < 4; i++){
                    for(int j = -1; j <= 1; j += 2){
                        char[] chs = w.toCharArray();
                        chs[i] = (char)((chs[i] - '0' + j + 10) % 10 + '0');
                        String t = new String(chs);
                        if(t.equals(target)) return step;
                        if(dead.contains(t) || visited.contains(t)) continue;
                        q.offer(t);
                        visited.add(t);
                    }
                }
            }
        }
        return -1;
    }
}

//Bidirectional BFS
class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> dead =  new HashSet<>();
        for(String word : deadends) dead.add(word);
        String start = "0000";
        //special adjugement
        if(start.equals(target)) return 0;
        if(dead.contains(start)) return -1;

        Queue<String> q1 = new ArrayDeque<>();
        q1.offer(start);
        Queue<String> q2 = new ArrayDeque<>();
        q2.offer(target);

        Set<String> visited1 = new HashSet<>();
        visited1.add(start);
        Set<String> visited2 = new HashSet<>();
        visited2.add(target);

        int step1 = 0;
        int step2 = 0;

        while(!q1.isEmpty() && !q2.isEmpty()){
            if(!q1.isEmpty()) step1++;
            for(int s = q1.size(); s > 0; s--){
                String w = q1.poll();
                for(int i = 0; i < 4; i++){
                    for(int j = -1; j <= 1; j += 2){
                        char[] chs = w.toCharArray();
                        chs[i] = (char)((chs[i] - '0' + j + 10) % 10 + '0');
                        String t = new String(chs);
                        if(visited2.contains(t)) return step1 + step2;
                        if(dead.contains(t) || visited1.contains(t)) continue;
                        q1.offer(t);
                        visited1.add(t);
                    }
                }
            }
            Queue<String> tmp1 = q1;
            q1 = q2;
            q2 = tmp1;

            Set<String> tmp2 = visited1;
            visited1 = visited2;
            visited2 = tmp2;

            int tmp3 = step1;
            step1 = step2;
            step2 = tmp3;

        }
        return -1;
    }
}