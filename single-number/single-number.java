class Solution {
    public int singleNumber(int[] nums) {
        HashSet<Integer> checker = new HashSet();
        for(int item : nums) {
            if(checker.add(item) == false) {
                checker.remove(item);
            }
        }
        int ret = 0; 
        for(int element : checker) {
            ret = element;
        }
        return ret;
    }
}
