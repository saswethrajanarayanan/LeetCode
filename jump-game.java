class Solution {
    public boolean canJump(int[] nums) {
        int lastindex = nums.length - 1;
        for (int i =nums.length - 1; i >= 0; --i) {
            if(i + nums[i] >= lastindex) {
                lastindex = i;
            }
        }
        return lastindex == 0;
    }
}
