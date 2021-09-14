class Solution {
    public int minSteps(String s, String t) {
        HashMap<Character, Integer> map_s = new HashMap();
        HashMap<Character, Integer> map_t = new HashMap();
        int count = 0;
        for(char c: s.toCharArray()) {
            map_s.put(c, map_s.getOrDefault(c, 0) + 1);
        }
        for(char c: t.toCharArray()) {
            map_t.put(c, map_t.getOrDefault(c, 0) + 1);
        }
        for(char c: map_s.keySet()) {
            if(!map_t.containsKey(c)) {
                count += map_s.get(c);
            }
            else {
                if(map_s.get(c) > map_t.get(c)) {
                    count += map_s.get(c) - map_t.get(c);
                }
                else {
                    continue;
                }
            }
        }
        return count;
    }
}


    
