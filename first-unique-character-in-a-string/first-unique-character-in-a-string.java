class Solution {
    public int firstUniqChar(String s) {
        List<Character> remains = new ArrayList();
        HashSet<Character> letters = new HashSet();
        for(char c : s.toCharArray()) {
            if(!letters.add(c)) {
                if(remains.contains(c)) {
                    remains.remove(new Character(c));
                }
            }
            else {
                remains.add(c);
            }
        }
        return remains.size() == 0 ? -1 : s.indexOf(remains.get(0));
    }
}