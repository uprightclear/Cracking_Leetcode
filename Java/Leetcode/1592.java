class Solution {
    public String reorderSpaces(String text) {
        String[] words = text.trim().split("\\s+");
        int cnt = words.length;
        int spaces = 0;
        for(char c : text.toCharArray()) {
            if(c == ' ') spaces++;
        }
        int gap = cnt <= 1 ? 0 : spaces / (cnt - 1); 
        int trailingSpaces = spaces - gap * (cnt - 1);
        return String.join(" ".repeat(gap), words) + " ".repeat(trailingSpaces);   
    }
}