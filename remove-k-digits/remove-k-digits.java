class Solution {
    public String removeKdigits(String num, int k) {
        if(k ==  num.length()) {
            return "0";
        }
        int OGLength = num.length();
        while(k != 0) {
            for(int i = 0; i < num.length() - 1; ++i) {
                if(num.charAt(i) - '0' > num.charAt(i + 1) -'0') {
                    if(i == 0) {
                        num = num.substring(1);
                    }
                    else {
                        num = num.substring(0, i) + num.substring(i + 1);   
                    }
                    break;
                }
            }
            if(num.length() == OGLength) {
                num = num.substring(0, num.length() - 1);
            }
            OGLength = num.length();
            k--;
        }
        //System.out.println(num);
        while(num.length() > 1 && num.charAt(0) == '0') {
            num = num.substring(1);
            //System.out.println(num);
        }
        //System.out.println(num);
        return num;
    }
}
// 159621
// 15621
// 1521
    