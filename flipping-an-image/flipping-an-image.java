class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        for(int i = 0; i < A.length; ++i) {
            swap(A[i], 0, A[i].length - 1);
            for(int j = 0; j < A[i].length; ++j) {
                if(A[i][j] == 0) A[i][j] = 1;
                else if(A[i][j] == 1) A[i][j] = 0;
            }
        }
        return A;
    }
    private void swap(int[] matrix, int i, int j) {
        while(i < j) {
            int temp = matrix[i];
            matrix[i] = matrix[j];
            matrix[j] = temp;
            i++;
            j--;
        }
    }
}
