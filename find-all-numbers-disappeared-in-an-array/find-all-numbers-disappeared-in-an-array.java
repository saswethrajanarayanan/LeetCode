class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList();
        HashSet<Integer> set = new HashSet();
        for(int item : nums) {
            set.add(item);
        }
        for(int i = 1; i <= nums.length; ++i) {
            if(set.add(i)) result.add(i);
        }
        return result;
    }
}
