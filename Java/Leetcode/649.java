class Solution {
    public String predictPartyVictory(String senate) {
        int rCount = 0, dCount = 0;
        // use vote to record any possible senate who has been banned by previous opponent.
        boolean[] vote = new boolean[senate.length()];
        
        // rCount == senate.length() or dCount == senate.length()
        // meaning one of the two sides has eaten all opponents.
        while (rCount < senate.length() && dCount < senate.length())
        {
            for (int i = 0; i < senate.length() && rCount < senate.length() && dCount < senate.length(); i++)
            {
				// this voter has been banned already.
                if (vote[i])
                    continue;
                
				// current senate from Ridiant
                if (senate.charAt(i) == 'R')
                {
					// previous left senates from Dire are more, then banned this senate.
                    if (rCount < dCount)
                        vote[i] = true;
                    rCount++;    
                } 
                else
                {
					// previous left senates from Radiant are more, then banned this senate.
                    if (dCount < rCount)
                        vote[i] = true;
                    dCount++;
                }
            }
        }
        
        // all senate place has been replaced with only one victor.
        if (rCount == senate.length())
            return "Radiant";
        else
            return "Dire";
    }
}