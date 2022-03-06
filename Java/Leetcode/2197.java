class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        while (true) {
            // 正着遍历，合并一次
            List<Integer> merged = merge(list);
            if (list.size() == merged.size()) { // 合并前后长度一致，说明无法再合并，直接返回
                return merged;
            }
            // 反着遍历，合并一次
            list = reverse(merge(reverse(merged)));
        }
    }

   private List<Integer> merge(List<Integer> nums) {
        List<Integer> res = new ArrayList<>();
        if (nums.size() == 1) {
            res.add(nums.get(0));
            return res;
        }
        // 一次合并中，令 i, j 表示相邻的两个元素
        // 当 nums[i], nums[j] 可合并时，nums[i] = lcm, j++ 即可
        // 最终将结果 add 到 res 中
        for (int i = 0, j = 1; j < nums.size(); j++) {
            int g = gcd(nums.get(i), nums.get(j));
            if (g > 1) {
                nums.set(i, nums.get(i) / g * nums.get(j));
                if (j == nums.size() - 1) {
                    res.add(nums.get(i));
                }
            } else {
                res.add(nums.get(i));
                i = j;
                if (j == nums.size() - 1) {
                    res.add(nums.get(j));
                }
            }
        }
        return res;
    }

    private List<Integer> reverse(List<Integer> list) {
        List<Integer> rev = new ArrayList<>();
        for (int i = list.size() - 1; i >= 0; i--) {
            rev.add(list.get(i));
        }
        return rev;
    }


    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}