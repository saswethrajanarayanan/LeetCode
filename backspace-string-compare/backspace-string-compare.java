class Solution {
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> SStack= new Stack();
        Stack<Character> TStack= new Stack();
        for(int i = 0; i < S.length(); ++i) {
            if(S.charAt(i) != '#') {
                SStack.push(S.charAt(i));
            }
            if(S.charAt(i) == '#' && !SStack.isEmpty()) {
                SStack.pop();
            }
        }
        for(int i = 0; i < T.length(); ++i) {
            if(T.charAt(i) != '#') {
                TStack.push(T.charAt(i));
            }
            if(T.charAt(i) == '#' && !TStack.isEmpty()) {
                TStack.pop();
            }
        }
        Iterator s = SStack.iterator();
        Iterator t = TStack.iterator();
        String news = "";
        String newt = "";
        while(s.hasNext()) {
            news += s.next();
        }
        System.out.println(news);
        while(t.hasNext()) {
            newt += t.next();
        }
        System.out.println(newt);
        return (newt.equals(news));
    }
}
