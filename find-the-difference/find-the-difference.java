class Solution {
    public char findTheDifference(String s, String t) {
        Stack<Character> st = new Stack();
        if(s.length() == 0) return t.charAt(0);
        for(int i = 0; i < s.length(); ++i) {
            st.push(s.charAt(i));
        }
        int result = 0;
        for(int i = 0; i < t.length(); ++i) {
            if(!st.isEmpty() && st.search(t.charAt(i)) != -1) {
                st.remove(st.size() - st.search(t.charAt(i)));
            }
            else {
                result = i;
            }
        }
        return t.charAt(result);
    }
}
