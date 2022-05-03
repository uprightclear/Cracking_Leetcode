class Solution {
	public int countDistinct(int[] nums, int k, int p) {
		HashSet<String> hs = new HashSet<>();
		for(int i = 0; i < nums.length; i++) {
			int cnt = 0;
			StringBuilder sb = new StringBuilder();
			for(int j = i; j < nums.length; ++j) {
				if(nums[j] % p == 0) cnt++;
                if(cnt > k) break;
				sb.append(nums[j] + ",");
				hs.add(sb.toString());
			}
		}
		return hs.size();
	}
}