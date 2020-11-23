class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        vector<int> vi;
            int a = 0;
            int b;
            vector<int>::iterator it;
            for(int i = 0; i < nums.size(); i++){
                a = target - nums[i];
                it = find(nums.begin(), nums.end(), a);
                b = it-nums.begin();
                    if(it != nums.end()){
                        if(b == i){
                            b = 0;
                            continue;
                        }
                        vi.push_back(i);
                        vi.push_back(it-nums.begin());
                        break;
                    }
                    else continue;           
            }
            
        return vi;
    }
};
