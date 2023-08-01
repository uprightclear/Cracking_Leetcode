class Solution {  
    public long[] minimumCosts(int[] regular, int[] express, int switchingCost) 
    {      
      long[] minCostReg = new long[regular.length+1];
      long[] minCostExp = new long[regular.length+1];
      long[] ans = new long[regular.length];
        
      minCostReg[0] = 0;
      minCostExp[0] = switchingCost;
        
      for (int i = 0; i<regular.length; i++)  
      {     
           ans[i] = 
                Math.min(
                    (minCostReg[i] + regular[i]), // Going from reg stop to next reg
                    (minCostExp[i] + express[i]) // Going from prev express stop to cur express
                );
          
          minCostReg[i+1] = Math.min(
              minCostReg[i] + regular[i], // going from previous reg to cur reg
              minCostExp[i] + express[i]  // going from previous exp to cur expr stop and then switching lanes to reg
          );

          minCostExp[i+1] = Math.min(
              minCostReg[i+1] + switchingCost, // reaching cur reg stop and switching to express
              minCostExp[i] + express[i] // moving from previous exp to cur expres
          );    
      }
    return ans;        
   }   
}