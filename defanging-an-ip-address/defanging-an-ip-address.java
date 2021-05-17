class Solution {
    public String defangIPaddr(String address) {
        String result = "";
        for(int i = 0; i < address.length(); ++i) {
            result += address.charAt(i);
            if(i == address.length() - 1) continue;
            if(address.charAt(i + 1) == '.') {
                result += '[';
            }
            if(address.charAt(i) == '.') {
                result += ']';
            }
        }
        return result;
    }
}