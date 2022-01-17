class Solution {
    public int minMoves(int target, int maxDoubles) {
        int step = 0;
        while(target != 1 && maxDoubles > 0) {
            if(target % 2 != 0) {
                target = (target - 1) / 2;
                step += 2;
            }else {
                target /= 2;
                step += 1;
            }
            maxDoubles--;

        }
        if(target != 1) step += target - 1;
        return step;
    }
}

//more elegant
class Solution {
    public int minMoves(int target, int k) {
        int res = 0;
        while (target > 1 && k > 0) {   
            res += 1 + target % 2;
            k--;
            target >>= 1;
        }
        return target - 1 + res;
    }
}