class Solution {
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, Integer> left = new HashMap();
        HashMap<Integer, Integer> right = new HashMap();
        HashMap<Integer, Integer> count = new HashMap();
        for(int i = 0; i < nums.length; ++i) {
            if(left.get(nums[i]) == null) left.put(nums[i], i);
            right.put(nums[i], i);
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
        }
        int degree = Collections.max(count.values());
        int result = Integer.MAX_VALUE;
        for(int i : count.keySet()) {
            if(count.get(i) == degree) {
                result = Math.min(result, right.get(i) - left.get(i) + 1);
            }
        }
        return result;
    }
}