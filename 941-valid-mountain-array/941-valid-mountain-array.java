class Solution {
    public boolean validMountainArray(int[] arr) {
        boolean increasing = false;
        boolean decreasing = false;
        if(arr.length <= 1) return false;
        for(int i = 1; i < arr.length; ++i) {
            if(arr[i] == arr[i - 1]) return false;
            if(!increasing && !decreasing) {
                if(arr[i] > arr[i - 1]) {
                    increasing = true;
                }
                else if(arr[i] < arr[i - 1]) {
                    decreasing = true;
                    return false;
                }
                else {
                    return false;
                }
            }
            else {
                if(arr[i] > arr[i - 1]) {
                    if(decreasing) {
                        return false;
                    }
                    increasing = true;
                    decreasing = false;
                }
                if(arr[i] < arr[i - 1]) {
                    decreasing = true;
                    increasing = false;
                }
            }
        }
        if(!decreasing) {
            return false;
        }
        return true;
    }
}