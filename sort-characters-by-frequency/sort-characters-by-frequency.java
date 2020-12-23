class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap();
        for(char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Character> maxheap = new PriorityQueue((a, b) -> map.get(b) - map.get(a));
        maxheap.addAll(map.keySet());
        
        StringBuilder result = new StringBuilder();
        
        while(!maxheap.isEmpty()) {
            char current = maxheap.remove();
            for(int i = 0; i < map.get(current); ++i) {
                result.append(current);
            }
        }
        return result.toString();
    }
}
