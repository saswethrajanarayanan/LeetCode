class Solution {
    public int countPrimes(int n) {
        boolean[] prime = new boolean[n];
        for(int i = 0; i < prime.length; ++i) {
            prime[i] = true;
        }
        
        int primecount = 0;
        for(int i = 2; i * i < prime.length; ++i) {
            for(int j = i; i * j < prime.length; ++j) {
                if(prime[i]) {
                    prime[i * j] = false;
                }
            }
        }
        for(int i = 2; i < prime.length; ++i) {
            if(prime[i]) primecount++;
        }
        return primecount;
    }
}
