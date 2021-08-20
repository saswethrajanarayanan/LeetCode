class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        HashMap<Character, Integer> pond = new HashMap();
        for(char c: s.toCharArray()) {
            pond.put(c, 1 + pond.getOrDefault(c, 0));
        }
        for(char c: t.toCharArray()) {
            int k = pond.getOrDefault(c, 0);
            if(k == 0) return false;
            k = k - 1;
            pond.put(c, k);
        }
        return true;
    }
}