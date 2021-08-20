class Solution {
    public void moveZeroes(int[] nums) {
        int left = 0;
        for(int i = 0; i < nums.length; ++i) {
            left = i;
            if(nums[left] != 0) continue;
            for(int j = left + 1; j < nums.length; ++j) {
                if(nums[j] == 0) continue;
                int right = j;
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                break;
            }
        }
        return;
    }
}