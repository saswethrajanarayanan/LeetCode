class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result= new ArrayList();
        List<Integer> sub_res = new ArrayList();
        btrack(result, sub_res, 1, n, k);
        return result;
    }
    private void btrack(List<List<Integer>> result, List<Integer> sub_res, int idx, int n, int k) {
        if(sub_res.size() == k) {
            result.add(new ArrayList(sub_res));
            return;
        }
        
        for(int i = idx; i <= n; ++i) {
            sub_res.add(i);
            btrack(result, sub_res, i + 1, n, k);
            sub_res.remove(sub_res.size() - 1);
        }
    }
}
