class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> words = new HashMap<>();
        for(String str : strs) {
            String word = strSort(str);
            if(words.containsKey(word)) {
                words.get(word).add(str);
            }
            else {
                List<String> sub_res = new ArrayList<>();
                sub_res.add(str);
                words.put(word, sub_res);
            }
        }
        return new ArrayList(words.values());
    }
    public String strSort(String str) {
        int[] counter = new int[26];
        for(char c : str.toCharArray()) {
            counter[c - 'a']++;
        }
        String t = "";
        for(int i = 0; i < 26; ++i) {
            char[] chars = new char[counter[i]];
            Arrays.fill(chars, (char)(i + 'a'));
            t += new String(chars);
        }
        return t;
    }
}