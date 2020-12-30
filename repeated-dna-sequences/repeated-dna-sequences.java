class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList();
        if(s.length() < 10 || s.length() >= Math.pow(10, 5)) return result;
        int left = 0;
        int right = left + 10;
        System.out.println(s.length());
        for(int i = left; i < s.length(); ++i) {
            right = i + 1;
            if(right >= s.length()) break;
            if(i + 10 > s.length()) break; 
            String target = s.substring(i, i + 10);
            for(int j = right; j < s.length(); ++j) {
                if(j + 10 > s.length()) break;
                String finder = s.substring(j, j + 10);
                if(finder.equals(target) && !result.contains(target)) result.add(target); 
            }
        }
        return result;
    }
}
