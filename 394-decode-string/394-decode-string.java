class Solution {
    public String decodeString(String s) {
        Stack<Integer> iters = new Stack<>();
        Stack<StringBuilder> words = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int k = 0;
        for(char c : s.toCharArray()) {
            if(Character.isDigit(c)) {
                k = (k * 10) + (c - '0');
            }
            else if(c == '[') {
                iters.push(k);
                words.push(sb);
                sb = new StringBuilder();
                k = 0;
            }
            else if(c == ']') {
                int iter = iters.peek();
                StringBuilder newString = words.peek();
                iters.pop();
                words.pop();
                for(int i = 0; i < iter; ++i) {
                    newString.append(sb);
                }
                sb = newString;
            }
            else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}