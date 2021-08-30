class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> partitions = new ArrayList();
        int[] lastIndex = new int[26];
        for(int i = 0; i < s.length(); ++i) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }
        int start = 0;
        while(start < s.length()) {
            int end = lastIndex[s.charAt(start) - 'a'];
            int next = start;
            while(next != end) {
                end = Math.max(end, lastIndex[s.charAt(next) - 'a']);
                next++;
            }
            partitions.add(end - start + 1);
            start = end + 1;
        }
        return partitions;
    }
}