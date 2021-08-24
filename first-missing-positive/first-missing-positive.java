class Solution {
    public int firstMissingPositive(int[] nums) {
        for(int i = 0; i < nums.length; ++i) {
            if(nums[i] <= 0) continue;
            int position = nums[i] - 1;
            while(nums[i] >= 1 && nums[i] <= nums.length && nums[i] != nums[position]) {
                int temp = nums[i];
                nums[i] = nums[position];
                nums[position] = temp;
                position = nums[i] - 1;
            }
        }
        for(int i = 0; i < nums.length; ++i) {
            if(i + 1 != nums[i]) {
                return i + 1;
            }
        }
        return nums[nums.length - 1] + 1;
    }
}