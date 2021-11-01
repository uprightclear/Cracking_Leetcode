class Solution {
    public int maximizeSweetness(int[] sweetness, int k) {
        // Initialize the left and right boundaries.
        // left = 1 and right = total sweetness / number of people.
        int numberOfPeople = k + 1;
        int left = Arrays.stream(sweetness).min().getAsInt();
        int right = Arrays.stream(sweetness).sum() / numberOfPeople;

        while (left < right) {
            // Get the middle index between left and right boundary indexes.
            // cur_sweetness stands for the total sweetness for the current person.
            // people_with_chocolate stands for the number of people that have 
            // a piece of chocolate of sweetness greater than or equal to mid.  
            int mid = (left + right + 1) / 2;
            int curSweetness = 0;
            int peopleWithChocolate = 0;
            
            // Start assigning chunks to the current people,.
            for (int s : sweetness) {
                curSweetness += s;
                
                // If the total sweetness for him is no less than mid, meaning we 
                // have done with him and should move on to assigning chunks to the next people.
                if (curSweetness >= mid) {
                    peopleWithChocolate += 1;
                    curSweetness = 0;
                }
            }
            
            // Check if we successfully give everyone a piece of chocolate with sweetness
            // no less than mid, and eliminate the search space by half.
            if (peopleWithChocolate >= numberOfPeople) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        
        // Once the left and right boundaries coincide, we find the target value,
        // that is, the maximum possible sweetness we can get.
        return left;
    }
}