class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        List<Integer> sub_res = new ArrayList();
        btrack(result, sub_res, nums);
        return result;
    }
    private void btrack(List<List<Integer>> result, List<Integer> sub_res, int[] nums) {
        if(sub_res.size() == nums.length) {
            System.out.println(sub_res);
            result.add(new ArrayList<Integer>(sub_res));
            return;
        }
        
        for(int i = 0; i < nums.length; ++i) {
            if(sub_res.contains(nums[i]) == false) {
                sub_res.add(nums[i]);
                btrack(result, sub_res, nums);
                sub_res.remove(sub_res.size() - 1);
            }
            else {
                continue;
            }
        }
    }
}
