class Solution {
    public int bagOfTokensScore(int[] tokens, int P) {
        Arrays.sort(tokens);
        if(tokens.length == 0) return 0;
        if(P < tokens[0]) {
            return 0;
        }
        int min = 0;
        int max = tokens.length - 1;
        int points = 0;
        int maxpoints = 0;
        
        while(min <= max) {
            if(P >= tokens[min]) {
                P -= tokens[min];
                points++;
                min++;
                maxpoints = Math.max(maxpoints, points);
            }
            else if(points > 0) {
                P += tokens[max];
                max--;
                points--;
            }
            else return maxpoints;
        }
        return maxpoints;
    }
}
 
