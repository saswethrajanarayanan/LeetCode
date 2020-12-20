class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        int result = 0;
        for(int i = nums.length - 1; i >= nums.length - k; --i) {
            result = nums[i];
        }
        return result;
    }
}
