class Solution {
    public boolean canPartition(int[] nums) {
        int total = 0;
        for(int value: nums) {
            total += value;
        }
        if(total % 2 != 0) return false;
        return btrack(nums, 0, 0, total, new HashMap<String, Boolean>());
    }
    private boolean btrack(int[] nums, int index, int sum, int total, HashMap<String, Boolean> store) {
        String current = index + "" + sum;
        if(store.containsKey(current)) {
            return store.get(current);
        }
        
        if(sum == total / 2) return true;
        
        if(sum > total / 2 || index >= nums.length) return false;
        
        boolean found = btrack(nums, index + 1, sum, total, store) || btrack(nums, index + 1, sum + nums[index], total, store);
        store.put(current, found);
        return found;
    }
}