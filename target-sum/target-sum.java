class Solution {
    HashMap<String, Long> store = new HashMap<String, Long>();
    public int findTargetSumWays(int[] nums, int S) {
        if(nums.length == 0) return 0;
        return (int) (btrack(nums, nums.length, nums[0], 1, S) + btrack(nums, nums.length, -nums[0], 1, S));
    }
    public long btrack(int[] nums, int len, int sum, int index, int S) {
        String current = Integer.toString(index) + "*" + Integer.toString(sum);
        System.out.println(current);
        
        if(store.containsKey(current)) {
            return store.get(current);
        }
        
        if(index == len) {
            return sum == S ? 1 : 0;
        }
        long value = btrack(nums, len, sum + nums[index], index + 1, S) + btrack(nums, len, sum - nums[index], index + 1, S);
        
        store.put(current, value);
        
        return value;
    }
}