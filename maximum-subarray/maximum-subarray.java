class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int global = nums[0];
        for(int i = 1; i < nums.length; ++i) {
            max = Math.max(nums[i], nums[i] + max);
            if(max > global) global = max;
        }
        return global;
    }
}
