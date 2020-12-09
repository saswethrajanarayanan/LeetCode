class Solution {
    public boolean search(int[] nums, int target) {
        if(nums.length == 0) return false;
        int left = 0;
        int right = nums.length - 1;
​
        for(int i = 0; i < nums.length - 1; ++i) {
            if(nums[i] > nums[i + 1]) {
                left = i + 1;
                break;
            }
        }
        int start = left;
        left = 0;
        right = nums.length - 1;
        
        if(target > nums[start] && target > nums[right]) {
            left = 0;
            right = start - 1;
        }
        else {
            left = start;
            right = nums.length - 1;
        }
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] == target) return true;
            if(nums[mid] > target) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return false;
    }
}
