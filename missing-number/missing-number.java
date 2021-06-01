class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int last = nums[nums.length - 1];
        for(int i = 0; i < nums.length; ++i) {
            if(nums[i] != i) {
                return i;
            }
        }
        return last + 1;
    }
}