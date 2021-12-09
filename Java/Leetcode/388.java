class Solution {
    public int lengthLongestPath(String input) {
        String[] paths = input.split("\n");
        int[] stack = new int[paths.length+1];
        int maxLen = 0;
        for(String s : paths){
            int lev = s.lastIndexOf("\t") + 1, curLen = stack[lev + 1] = stack[lev] + s.length() - lev + 1;
            if(s.contains(".")) maxLen = Math.max(maxLen, curLen - 1);
        }
        return maxLen;
    }
}



private int res = 0;
public int lengthLongestPath(String input) {
    if(input.indexOf('.') < 0) return 0;
    String[] arr = input.split("\n");
    dfs(arr, -1, 0, 0);
    return res;
}

private void dfs(String[] arr, int curLength, int index, int level){
    for (int i = index; i < arr.length; i++){
        int current = curLength;
        if (countTabs(arr[i]) == level) {
            current += arr[i].length() - level + 1;
            if (isFile(arr[i])){
                res = Math.max(current, res);
            }
            dfs(arr, current, i + 1, level + 1);
        }
        if (countTabs(arr[i]) < level){
            break;
        }
    }
}

// first we have to judge if the input is a file or not
// only 
private boolean isFile(String input){
    for(char c: input.toCharArray()){
        if(c == '.') return true;
    }
    return false;
}

// the \t marks the current level we are in
private int countTabs(String input){
    int count = 0;
    for(char c: input.toCharArray()){
        if(c == '\t') count++;
    }
    return count;
}