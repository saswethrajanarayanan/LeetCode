class Solution {
    public int candy(int[] ratings) {
        int[] forward = new int[ratings.length];
        Arrays.fill(forward, 1);
        int[] backward = new int[forward.length];
        Arrays.fill(backward, 1);
        
        for(int i = 1; i < forward.length; ++i) {
            if(ratings[i] > ratings[i - 1]) {
                forward[i] = forward[i - 1] + 1;
            }
        }
        for(int i = forward.length - 2; i >= 0; --i) {
            if(ratings[i] > ratings[i + 1]) {
                backward[i] = backward[i + 1] + 1;
            }
        }
        int total = 0;
        for(int i = 0; i < ratings.length; ++i) {
            total += Math.max(forward[i], backward[i]);
        }
        return total;
    }
}
