class Solution {
    public String reverseVowels(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();
        int l = 0, r = n - 1;
        while(l < r){
            while(l < n && !isVowel(arr[l])) l++;
            while(r > 0 && !isVowel(arr[r])) r--;
            if(l < r){
                swap(arr, l, r);
                l++;
                r--;
            }
        }
        return new String(arr);
    }

    public boolean isVowel(char ch){
        return "aeiouAEIOU".indexOf(ch) >= 0;
    }

    public void swap(char[] arr, int l, int r){
        char temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp; 
    }
}