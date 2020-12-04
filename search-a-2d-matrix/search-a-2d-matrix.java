class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int check = 0;
        if(matrix.length == 0 || (matrix.length != 0 && matrix[0].length == 0)) return false;
        int left = 0;
        int right = matrix[0].length - 1;
        int dest = 0;
        for(int i = 0; i < matrix.length; ++i) {
            if(target <= matrix[i][matrix[i].length - 1]) {
                dest = i;
                check++;
                break;
            }
        }
        if(check == 0) {
            return false;
        }
        
        while(left <= right) {
            if(left == right) {
                if(matrix[dest][left] == target || matrix[dest][right] == target) return true;
                else return false;
            }
            int midpoint = left + (right - left) / 2;
            if(matrix[dest][midpoint] == target) {
                return true;
            }
            if(matrix[dest][midpoint] > target) {
                right = midpoint;
            }
            if(matrix[dest][midpoint] < target) {
                left = midpoint + 1;
            }
        }
        return false;
    }
}
