class Solution {
    public int mySqrt(int x) {
        int sqrt = 0;
        for(int i = 0; i <= x; ++i) {
            if(Math.pow(i, 2) <= x) {
                sqrt = i;
            }
            else break;
        }
        return sqrt;
    }
}
