class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        for(int i = 0; i < nums.length - 1; ++i) {
            if(nums[i] > nums[i + 1]) {
                left = i + 1;
                break;
            }
        }
        return nums[left];
    }
}
