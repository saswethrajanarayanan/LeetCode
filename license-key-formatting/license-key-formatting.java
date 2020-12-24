class Solution {
    public String licenseKeyFormatting(String S, int K) {
        int key = K;
        String result = "";
        for(int i = S.length() - 1; i >= 0; --i) {
            key = K;
            while(key > 0 && i >= 0) {
                if(S.charAt(i) == '-') {
                    i--;
                    continue;
                }
                result = Character.toUpperCase(S.charAt(i)) + result;
                key--;
                i--;
            }
            i++;
            result = '-' + result;
        }
        int i = 1;
        while(result.charAt(0) == '-') {
            if(result.length() > 1) result = result.substring(1, result.length());
            else {
                result = "";
                break;
            }
        }
        return result;
    }
}
