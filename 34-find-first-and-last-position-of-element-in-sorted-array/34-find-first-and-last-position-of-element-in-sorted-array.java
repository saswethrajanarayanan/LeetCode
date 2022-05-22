class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        Arrays.fill(result, -1);
        if(nums.length == 0) {
            return result;
        }
        findLeft(nums, result, target);
        findRight(nums, result, target);
        return result;
    }
    public void findLeft(int[] nums, int[] result, int target) {
        int left = 0;
        int right = nums.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] < target) {
                left = mid + 1;
            }
            if(nums[mid] == target) {
                result[0] = mid;
            }
            if(nums[mid] >= target) {
                right = mid - 1;
            }
        }
    }
    public void findRight(int[] nums, int[] result, int target) {
        int left = 0;
        int right = nums.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] <= target) {
                left = mid + 1;
            }
            if(nums[mid] == target) {
                result[1] = mid;
            }
            if(nums[mid] > target) {
                right = mid - 1;
            }
        }
    }
}