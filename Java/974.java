//Time Limit Exceeded
class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int ans = 0;
        int len = nums.length;
        int[] preSum = new int[len + 1];
        preSum[0] = 0;
        for(int i = 1; i <= len; i++) {
            preSum[i] = nums[i - 1] + preSum[i - 1];
        }
        for(int i = 0; i <= len; i++) {
            for(int j = i + 1; j <= len; j++) {
                if((preSum[j] - preSum[i]) % k == 0) ans++;
            }
        }
        return ans;
    }
}


class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> record = new HashMap<Integer, Integer>();
        record.put(0, 1);
        int sum = 0;
        for (int elem : nums) {
            sum += elem;
            // 注意 Java 取模的特殊性，当被除数为负数时取模结果为负数，需要纠正
            int modulus = (sum % k + k) % k;
            record.put(modulus, record.getOrDefault(modulus, 0) + 1);
        }

        int ans = 0;
        for (Map.Entry<Integer, Integer> entry: record.entrySet()) {
            //Cn2
            ans += entry.getValue() * (entry.getValue() - 1) / 2;
        }
        return ans;
    }
}