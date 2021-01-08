class Solution {
    public int jump(int[] nums) {
        if(nums.length == 1) return 0;
        int pos = nums[0];
        int max_pos = nums[0];
        int jumps = 1;
        for (int i = 1; i < nums.length; ++i) {
            if (pos < i) {
                jumps++;
                pos = max_pos;
            }
            max_pos = Math.max(max_pos, nums[i] + i);
        }
        return jumps;
    }
}
