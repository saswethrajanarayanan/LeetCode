class Solution {
public:
    vector<vector<int>> combinationSum2(vector<int>& candidates, int target) {
        vector<vector<int>> result;
        vector<int> sub_res;
        sort(candidates.begin(), candidates.end());
        btrack(result, sub_res, candidates, 0, target);
        return result;
    }
private:
    void btrack(vector<vector<int>> &result, vector<int> &sub_res, vector<int> candidates, int idx, int target){
        //sort(candidates.begin(), candidates.end());
        if(target == 0){
            result.push_back(sub_res);
            return;
        }
        if(target < 0) return;
        for(int i = idx; i < candidates.size(); i++){
            if(candidates[i] > target) break;
            if(i > idx && candidates[i] == candidates[i-1]) continue;
            sub_res.push_back(candidates[i]);
            btrack(result, sub_res, candidates, i + 1, target - candidates[i]);
            sub_res.pop_back();
        }
    }
};
