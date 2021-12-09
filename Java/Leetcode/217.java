//Sort
class Solution {
    public boolean containsDuplicate(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        for(int i = 1; i < len; i++){
            if(nums[i] == nums[i - 1]) return true;
        }
        return false;
    }
}

//HashSet
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int x : nums) {
            if (!set.add(x)) {
                return true;
            }
        }
        return false;
    }
}