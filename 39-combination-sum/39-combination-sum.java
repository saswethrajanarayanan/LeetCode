class Solution {
    public List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> sub_res = new ArrayList<>();
        btrack(candidates, target, result, sub_res, 0, 0);
        return result;
    }
    public void btrack(int[] candidates, int target, List<List<Integer>> result, List<Integer> sub_res, int sum, int idx) {
        if(sum > target) {
            return;
        }
        if(sum == target) {
            result.add(new ArrayList(sub_res));
            return;
        }
        for(int i = idx; i < candidates.length; ++i) {
            sub_res.add(candidates[i]);
            btrack(candidates, target, result, sub_res, sum + candidates[i], i);
            sub_res.remove(sub_res.size() - 1);
        }
    }
}