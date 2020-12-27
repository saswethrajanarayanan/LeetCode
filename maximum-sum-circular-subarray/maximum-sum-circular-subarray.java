class Solution {
    public int maxSubarraySumCircular(int[] A) {
        int sum = 0;
        int arraysum = 0;  
        int max1 = A[0];
        int global1 = A[0];
        for(int i = 1; i < A.length; ++i) {
            max1 = Math.max(A[i], max1 + A[i]);
            if(max1 > global1) {
                global1 = max1;
            }
        }
        boolean positive = false;
        int min = Integer.MIN_VALUE;
        for(int i = 0; i < A.length; ++i) {
            if(A[i] >= 0) positive = true;
            min = Math.max(min, A[i]);
            A[i] = A[i] * -1;
            arraysum += A[i];
            
        }
        if(!positive) return min;
        int max = A[0];
        int global = A[0];
        for(int i = 1; i < A.length; ++i) {
            max = Math.max(A[i], max + A[i]);
            if(max > global) {
                global = max;
            }
        }
        int result = arraysum - global;
        return Math.max(global1, -1 * result);
    }
}
