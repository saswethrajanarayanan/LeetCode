class Solution {
    public boolean isValid(String s) {
        if(s.length() == 1) return false;
        HashMap<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()) {
            if(map.containsKey(c)) {
                stack.push(c);
            }
            else {
                if(stack.isEmpty()) {
                    return false;
                }
                char p = stack.peek();
                if(map.get(p) != c) {
                    return false;
                }
                else {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }
}