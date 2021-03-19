class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        if(s.equals("")) return 0;
        if(words.length == 0) return 0;
        int count = 0;
        HashMap<String, Boolean> map = new HashMap();

        for(String word : words) {
            int index = 0;
            if(map.containsKey(word)) {
                if(map.get(word)) {
                    count++;
                    continue;
                }
            }
            if(!map.containsKey(word)) {
                map.put(word, false);
                for(int i = 0; i < s.length(); ++i) {
                    if(word.charAt(index) == s.charAt(i)) {
                        index++;
                    }
                    if(index >= word.length()) {
                        map.put(word, true);
                        count++;
                        break;
                    }
                }
            }
        }
        return count;
    }
}