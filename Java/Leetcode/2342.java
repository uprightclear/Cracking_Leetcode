class Solution {
	public int maximumSum(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		int res = -1;
		for (int num : nums) {
			int s = 0;
			for (char digit: String.valueOf(num).toCharArray()) {
				s += Integer.valueOf(digit - '0');
			}
			if (!map.containsKey(s)) {
				map.put(s, num);
			} else {
				res = Math.max(res, map.get(s) + num);
				map.put(s, Math.max(map.get(s), num));
			}
		}
		return res;
	}
}