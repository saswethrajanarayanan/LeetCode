class Solution {
    public String breakPalindrome(String palindrome) {
        int left = 0;
        int right = palindrome.length() - 1;
        char replace = 'a';
        if(palindrome.length() == 1) return "";
        while(left < right) {
            if(palindrome.charAt(left) == palindrome.charAt(right)) {
                if(palindrome.charAt(left) != replace) {
                    palindrome = palindrome.substring(0, left) + replace + palindrome.substring(left + 1,
                                                                                    palindrome.length());
                    break;
                }
            }
            left++;
            right--;
        }
        right = palindrome.length() - 1;
        if(isPalindrome(palindrome)) {
            if(palindrome.charAt(right) == replace) {
                palindrome = palindrome.substring(0, right) + (char) (replace + 1) + palindrome.substring(right + 1, palindrome.length());   
            }
            else {
                palindrome = palindrome.substring(0, right) + replace + palindrome.substring(right + 1, palindrome.length());
            }
        }
        return palindrome;
    }
    private boolean isPalindrome(String palindrome) {
        int i = 0;
        int j = palindrome.length() - 1;
        while(i < j) {
            if(palindrome.charAt(i) != palindrome.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}