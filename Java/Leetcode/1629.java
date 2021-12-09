class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        char ans = keysPressed.charAt(0);
        int maxTime = releaseTimes[0] - 0;
        for (int i = 1; i < releaseTimes.length; i++) {
            int time = releaseTimes[i] - releaseTimes[i - 1];
            if (time > maxTime || time == maxTime && keysPressed.charAt(i) > ans) {
                ans = keysPressed.charAt(i);
                maxTime = time;
            }
        }
        return ans;
    }
}

class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int n = releaseTimes.length;
        int[] duration = new int[n];
        duration[0] = releaseTimes[0];
        int max = duration[0];
        for(int i = 1; i < releaseTimes.length; i++) {
            duration[i] = releaseTimes[i] - releaseTimes[i - 1];
            max = Math.max(max, duration[i]);
        }
        
        List<Character> res = new ArrayList<>();
        for(int j = 0; j < n; j++) {
            if(duration[j] == max) {
                res.add(keysPressed.charAt(j));
            }
        }
        
        Collections.sort(res);
        return res.get(res.size() - 1);
    }
}