class Solution {
    public int maxLength(List<String> arr) {
        int[] result = new int[1];
        dfs(arr, 0, "", result);
        return result[0];
    }
    public void dfs(List<String> arr, int index, String current, int[] result) {
        if(index == arr.size() && characterCount(current) > result[0]) {
            result[0] = current.length();
            return;
        }
        if(index == arr.size()) {
            return;
        }
        
        dfs(arr, index + 1, current, result);
        dfs(arr, index + 1, current + arr.get(index), result);
    }
    
    public int characterCount(String s) {
        int[] counts = new int[26];
        for(char c: s.toCharArray()) {
            if(counts[c - 'a']++ > 0) {
                return -1;
            }   
        }
        return s.length();
    }
}