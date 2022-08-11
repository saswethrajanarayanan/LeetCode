class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int rooms = 0;
        int[] lowerIntervals = new int[intervals.length];
        int[] upperIntervals = new int[intervals.length];
        
        for(int i = 0; i < intervals.length; ++i) {
            lowerIntervals[i] = intervals[i][0];
            upperIntervals[i] = intervals[i][1];
        }
        Arrays.sort(lowerIntervals);
        Arrays.sort(upperIntervals);
        
        int start = 0;
        int end = 0;
        
        while(start < intervals.length && end < intervals.length) {
            if(lowerIntervals[start] >= upperIntervals[end]) {
                rooms--;
                end++;
            }
            rooms++;
            start++;
        }
        return rooms;
    }
}
// 0 5 15;
// 10 20 30;

// 2 7;
// 4 10;