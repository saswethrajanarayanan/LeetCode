class Solution {
    public int lengthOfLIS(int[] nums) {
        TreeSet<Integer> redBlack = new TreeSet<>();
        for(int num : nums) {
            Integer higher = redBlack.ceiling(num);
            if(higher == null) {
                redBlack.add(num);
            }
            else {
                redBlack.remove(higher);
                redBlack.add(num);
            }
        }
        return redBlack.size();
    }
}