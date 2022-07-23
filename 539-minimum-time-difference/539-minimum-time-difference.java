class Solution {
    public int findMinDifference(List<String> timePoints) {
        boolean[] times = new boolean[1440];
        for(String str : timePoints) {
            int hour = Integer.parseInt(str.split(":")[0]);
            int min = Integer.parseInt(str.split(":")[1]);
            int currentTime = hour * 60 + min;
            if(times[currentTime]) return 0;
            times[currentTime] = true;
        }
        int prev = -1;
        int curr = -1;
        int first = -1;
        int minDiff = Integer.MAX_VALUE;
        for(int i = 0; i < 1440; ++i) {
            if(times[i]) {
                if(first == -1) {
                    first = i;
                }
                if(curr == -1) {
                    curr = i;
                    prev = i;
                    continue;
                }
                curr = i;
                minDiff = Math.min(minDiff, curr - prev);
                prev = curr;
            }
        }
        minDiff = Math.min(minDiff, 1440 - curr + first);
        return minDiff;
    }
}

// 0, 240, 1320;
// minDiff = 240, 240;
// minDiff = 240, 