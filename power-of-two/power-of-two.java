class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n == 0) return false;
        while(n != 0) {
            if(n != 1 && n % 2 != 0) return false;
            n = n / 2;
        }
        return true;
    }
}
