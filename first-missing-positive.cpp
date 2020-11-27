class Solution {
public:
    int firstMissingPositive(vector<int>& nums) {
        if(find(nums.begin(), nums.end(), 1) == nums.end()) return 1;
        int replace;
        for(int i = 0; i < nums.size(); ++i){
            if(nums[i] < 0) continue;
            replace = nums[i] - 1;
            while(nums[i] >= 1 && nums[i] <= nums.size() && nums[i] > 0 && nums[i] != nums[replace]){
                int temp = nums[i];
                nums[i] = nums[replace];
                nums[replace] = temp;
                replace = nums[i] - 1;
            }
        }
        for(int i = 0; i < nums.size(); ++i){
            if((nums[i] - 1) == i){
                continue;
            }
            return i + 1;
        }
        return nums.size() + 1;
    }
};
​
​
