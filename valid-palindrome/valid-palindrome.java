class Solution {
    public boolean isPalindrome(String s) {
        if(s.length() == 0) return true;
        char[] chars = new char[s.length()];
        chars = s.toCharArray();
        int i = 0;
        int j = s.length() - 1;
        while(i < j) {
            while(i < j && !Character.isLetterOrDigit(chars[i])) {
                i++;
            }
            while(i < j && !Character.isLetterOrDigit(chars[j])) {
                j--;
            }
            while(i < j && chars[i] == ' ') {
                i++;
            }
            while(i < j && chars[j] == ' ') {
                j--;
            }
            if(Character.isUpperCase(chars[i])) {
                chars[i] = Character.toLowerCase(chars[i]);
            }
            if(Character.isUpperCase(chars[j])) {
                chars[j] = Character.toLowerCase(chars[j]);
            }
            if(chars[i] == chars[j]) {
                i++;
                j--;
            }
            else {
                return false;
            }
        }
        return true;
    }
}
