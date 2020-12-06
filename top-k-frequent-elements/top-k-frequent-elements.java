class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> finder = new HashMap();
       int[] result = new int[k];
        int p = 0;
        
        for(int i = 0; i < nums.length; ++i) {
            if(finder.containsKey(nums[i])) {
                finder.put(nums[i], finder.get(nums[i]) + 1);
            }
            else {
                finder.put(nums[i], 1);
            }
        }
        
        
        while(p < k) {
            Map.Entry<Integer, Integer> maxel = null;
            for(Map.Entry<Integer, Integer> entry : finder.entrySet()) {
                if(maxel == null || entry.getValue().compareTo(maxel.getValue()) > 0) {
                    maxel = entry;
                }
            }
            result[p] = (maxel.getKey());
            finder.remove(maxel.getKey());
            p++;
        } 
        return result;
    }
}
