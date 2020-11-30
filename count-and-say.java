class Solution {
    public String countAndSay(int n) {
        String num = "1";
        int i = 1;
        while(i < n){
            String test = "";
            for(int k = 0; k < num.length(); ++k){
                int count = 1;
                int p = k;
                while((p + 1 < num.length()) && num.charAt(p) == num.charAt(p + 1)){
                    count++;
                    p++;
                }
                test += Integer.toString(count);
                test += num.charAt(k);
                k = p;
            }
            num = test;
            i++;
        }
        return num;
    }
}
