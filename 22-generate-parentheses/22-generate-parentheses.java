class Solution {
    List<String> result = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        btrack(result, "", 0, 0, n);
        return result;
    }
    public void btrack(List<String> result, String word, int openCount, int closedCount, int n) {
        if(word.length() == 2 * n) {
            result.add(word);
            return;
        }
        if(openCount < n) {
            btrack(result, word + '(', openCount + 1, closedCount, n);
        }
        if(closedCount < openCount) {
            btrack(result, word + ')', openCount, closedCount + 1, n);
        }
        return;
    }
}