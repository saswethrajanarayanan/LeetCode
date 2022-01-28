class Solution {
    public String longestCommonPrefix(String[] strs) {
        String word = strs[0];
        for(String str: strs) {
            while(str.indexOf(word) != 0) {
                word = word.substring(0, word.length() - 1);
                if(word.length() == 0) return "";
            } 
        }
        return word;
    }
}