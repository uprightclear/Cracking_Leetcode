class Solution {
    public String defangIPaddr(String address) {
        StringBuilder sb = new StringBuilder();
        for(int i = address.length() - 1; i >= 0; i--) {
            if(address.charAt(i) == '.') sb.append("].[");
            else sb.append(address.charAt(i));
        }
        return sb.reverse().toString();
    }
}