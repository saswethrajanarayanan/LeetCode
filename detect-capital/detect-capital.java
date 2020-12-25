class Solution {
    public boolean detectCapitalUse(String word) {
        int key = 0;
        for(char c : word.toCharArray()) {
            if(Character.isUpperCase(c)) key++;
        }
        char[] c = word.toCharArray();
        if(key == 0 || key == word.length() ||  (key == 1 && Character.isUpperCase(c[0]))) return true;
        else return false;
    }
}
