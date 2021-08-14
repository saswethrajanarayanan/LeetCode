class Solution {
    public int compress(char[] chars) {
        String s = "";
        if(chars.length == 1) {
            s += chars[0];
            return s.length();
        }
        int i = 0;
        while(i < chars.length) {
            char current = chars[i];
            int count = 1;
            for(int j = i + 1; j < chars.length; ++j) {
                if(chars[j] == current) {
                    count++;
                    if(j == chars.length - 1) i = chars.length;
                }
                else {
                    i = j;
                    break;
                }
            }
            s += current;
            if(count > 1) {
                s += count;
            }
            if(i == chars.length - 1) {
                s += chars[i];
                break;
            }
        }
        for(int j = 0; j < s.length(); ++j) {
            chars[j] = s.charAt(j);
        }
        char[] newChars = Arrays.copyOfRange(chars, 0, s.length());
        return newChars.length;
    }
}