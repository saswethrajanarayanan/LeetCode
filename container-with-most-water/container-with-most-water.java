class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int area = 0;
        while(left < right) {
            int base = right - left;
            int length = Math.min(height[left], height[right]);
            area = Math.max(area, length * base);
            if(height[left] < height[right]) {
                left++;
            }
            else {
                right--;
            }
        }
        return area;
    }
}