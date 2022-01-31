class Solution {
    public int maximalRectangle(char[][] matrix) {
        int[] height = new int[matrix[0].length];
        int[] left = new int[matrix[0].length];
        int[] right = new int[matrix[0].length];
        Arrays.fill(right, matrix[0].length);
        int max_area = 0;
        for(int i = 0; i < matrix.length; ++i) {
            int curr_left = 0; 
            int curr_right = matrix[i].length;
            for(int j = 0; j < matrix[i].length; ++j) {
                if(matrix[i][j] == '1') {
                    height[j]++;
                    left[j] = Math.max(left[j], curr_left);
                }
                else {
                    height[j] = 0;
                    left[j] = 0;
                    curr_left = j + 1;
                }
            }
            for(int j = matrix[i].length - 1; j >= 0; --j) {
                if(matrix[i][j] == '1') {
                    right[j] = Math.min(right[j], curr_right);
                }
                else {
                    right[j] = matrix[i].length;
                    curr_right = j;
                }
            }
            for(int j = 0; j < right.length; ++j) {
                max_area = Math.max(max_area, (right[j] - left[j]) * height[j]);
            }
        }
        return max_area;
    }
}