class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        for(int i = 0; i < nums1.length; i++){
            int x = nums1[i];
            for(int j = 0; j < nums2.length; j++){
                if(nums2[j] == x){
                    for(int k = j + 1; k < nums2.length; k++){
                        if(nums2[k] > x){
                            ans[i] = nums2[k];
                            break;
                        }
                    } 
                    break;
                }
            }
            if(ans[i] == 0) ans[i] = -1;
        }
        return ans;
    }
}

//brute force
public class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        int j;
    
        for (int i = 0; i < nums1.length; i++) {
            boolean found = false;
            for (j = 0; j < nums2.length; j++) {
                if (found && nums2[j] > nums1[i]) {
                    res[i] = nums2[j];
                    break;
                }
    
                if (nums2[j] == nums1[i]) {
                    found = true;
                }
            }
            if (j == nums2.length) {
                res[i] = -1;
            }
        }
    
        return res;
    }
}

//better brute force
public class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            hash.put(nums2[i], i);
        }
        
        int[] res = new int[nums1.length];
        int j;
                                                                  
        for (int i = 0; i < nums1.length; i++) {
            for (j = hash.get(nums1[i]) + 1; j < nums2.length; j++) {
                if (nums1[i] < nums2[j]) {
                    res[i] = nums2[j];
                    break;
                }
            }
            if (j == nums2.length) {
                res[i] = -1;
            }
        }
    
        return res;
    }
}

//stack
public class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();
    
        for (int i = 0; i < nums2.length; i++) {
            while (!stack.empty() && nums2[i] > stack.peek())
                map.put(stack.pop(), nums2[i]);
            stack.push(nums2[i]);
        }
    
        while (!stack.empty())
            map.put(stack.pop(), -1);
    
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.get(nums1[i]);
        }
                                            
        return res;
    }
}