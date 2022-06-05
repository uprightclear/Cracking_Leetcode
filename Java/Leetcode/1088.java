class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    int res = 0;

	public int confusingNumberII(int N) {
        map.put(0, 0);
        map.put(1, 1);
        map.put(6, 9);
        map.put(8, 8);
        map.put(9, 6);
		// begin with cur = 0
		helper(N, 0);
		return res;
	}

	private void helper(int N, long cur) {
		if (isConfusingNumber(cur)) {
			res++;
		}
		
		/*
		 * Iterate through all of possible numbers in dfs 
		 * Ex : when N = 22
		 * 1 
		 * 10 
		 * 11 
		 * 16 
		 * 18 
		 * 19  // stop here as this is last possible value before 22
		 * 
		 * 6 // No 2 digit value starting with 6 is < 22
		 * 8 
		 * 9
		 */
		for (Integer i : map.keySet()) {
			long next = cur * 10 + i;
			if (next <= N && next != 0) {
				//System.err.println(next);
				helper(N, next);
			}
		}
	}

	private boolean isConfusingNumber(long cur) {
		// lets say curr = 69
		long src = cur;
		long strobogrammticRotatedNumber = 0;
		/* Since we rotate 180, least significant digit would become most significant digit in strobogrammatic number.
		 * find each digit starting from least significant digit and get strobogrammatic digit. */
		while (cur > 0) {

			strobogrammticRotatedNumber = strobogrammticRotatedNumber * 10 + map.get((int) cur % 10); // 0*10+9%10 6 = 6   next loop 6*10 + 9 69
			//System.err.println(cur +" result = "+ strobogrammticRotatedNumber);
			cur /= 10;                                // 6            next loop
		}
		return strobogrammticRotatedNumber != src;
	}
}