class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        if(words.length == 1) return true;
        for(int i = 0; i < words.length - 1; ++i) {
            String first = words[i];
            String second = words[i + 1];
            int j = 0;
            while(j != first.length() && j != second.length()) {
                if(order.indexOf(first.charAt(j)) > order.indexOf(second.charAt(j))) {
                    return false;
                }
                if(order.indexOf(first.charAt(j)) < order.indexOf(second.charAt(j))) {
                    break;
                }
                j++;
                if(j == second.length() && j < first.length()) return false;
            }
        }
        return true;
    }
}