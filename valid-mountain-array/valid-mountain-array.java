class Solution {
    public boolean validMountainArray(int[] arr) {
        int left_one = 0;
        int right_one = 0;
        int left_two = 0;
        int right_two = arr.length - 1;
        
        for(int i = 0; i < arr.length - 1; ++i) {
            if(arr[i] > arr[i + 1]) {
                right_one = i;
                left_two = i + 1;
                break;
            }
        }
        if(right_one == left_one) {
            return false;
        }
        for(int i = left_one; i < right_one; ++i) {
            if(arr[i] >= arr[i + 1]) {
                return false;
            }
        }
        for(int i = left_two; i < right_two; ++i) {
            if(arr[i] <= arr[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
