class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap();
        int t = 0;
        for(int i = 0; i < nums.length; ++i) {
            if(!map.isEmpty() && map.containsKey(nums[i])) {
                if(Math.abs(i - map.get(nums[i])) <= k) t++;
                map.put(nums[i], i);
            }
            else {
                map.put(nums[i], i);
            }
        }
        return (t != 0);
    }
}
