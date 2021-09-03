class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for(int i = 0; i < nums.length; ++i) {
            int first = nums[i];
            int second = target - nums[i];
            int j = i + 1;
            while(j < nums.length) {
                if(nums[j] == second) {
                    result[0] = i;
                    result[1] = j;
                    break;
                }
                j++;
            }
        }
        return result;
    }
}