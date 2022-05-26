class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(String str: strs) {
            String converted = strSort(str);
            if(map.containsKey(converted)) {
                List<String> existing = map.get(converted);
                existing.add(str);
                map.put(converted, existing);
            }
            else {
                List<String> current = new ArrayList<>();
                current.add(str);
                map.put(converted, current);
            }
        }
        return new ArrayList(map.values());
    }
    public String strSort(String str) {
        int[] helper = new int[26];
        for(int i = 0; i < str.length(); ++i) {
            helper[str.charAt(i) - 'a'] += 1;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 26; ++i) {
            while(helper[i] != 0) {
                sb.append((char)(i + 'a'));
                helper[i] -= 1;
            }
        }
        return sb.toString();
    }
}