class Solution {
    public int maxNumberOfBalloons(String text) {
        if(text.length() == 0) return 0;
        char[] textarr = new char[text.length()];
        textarr = text.toCharArray();
        int result = 0;
        while(true) {
            int count = 0;
            String balloon = "balloon";
            for(int i = 0; i < balloon.length(); ++i) {
                int idx = text.indexOf(balloon.charAt(i));
                System.out.println(idx);
                if(idx != -1) {
                    count++;
                    textarr[idx] = 'k';
                    text = new String(textarr);
                }
                else {
                    count = 0;
                    break;
                }
            }
            if(count == 0) {
                break;
            }
            if(count == balloon.length()) {
                result++;
            }
            text = new String(textarr);
        }
        return result;
    }
}
