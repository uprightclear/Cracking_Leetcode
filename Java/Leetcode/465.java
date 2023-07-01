class Solution {
    public int minTransfers(int[][] transactions) {
        //create balance
        //dont move until load has been dropped
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int[] transaction : transactions){
            
            map.put(transaction[0], map.getOrDefault(transaction[0], 0) + transaction[2]);
            map.put(transaction[1], map.getOrDefault(transaction[1], 0) - transaction[2]);
            
        }
        
        int[] balances = new int[map.size()];
        int i = 0;
        for (int val : map.values()){
            balances[i++] = val;
        }
        return traverse(balances, 0);
        
    }
    
    private int traverse(int[] balances, int curBalanceIndex){
        
        //don't want to count +0 -0 as a move
        while(curBalanceIndex < balances.length && balances[curBalanceIndex] == 0) curBalanceIndex++;
        if (curBalanceIndex == balances.length) return 0;
        
        int curBalance = balances[curBalanceIndex];
        
        int minMoves = balances.length;
        
        for (int nextIndex = curBalanceIndex + 1; nextIndex < balances.length; nextIndex++){
            
            int nextBalance = balances[nextIndex];
            if (curBalance * nextBalance < 0){
                
                //place curBalance onto nextBalance as viable candidate
                balances[nextIndex] += curBalance;
                //traverse based on next number after curBalanceIndex not nextIndex
                //only iterates after curBalance based on curBalanceIndex has been combined into future balance sum
                minMoves = Math.min(minMoves, traverse(balances, curBalanceIndex+1) +1);
                //revert to potentially place burden of curBalance on other num
                balances[nextIndex] -= curBalance;
            }
            
        }
        return minMoves;
        
    }
    
    
}