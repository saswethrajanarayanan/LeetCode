class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int[] startTimes = new int[intervals.length];
        int[] endTimes = new int[intervals.length];
        int count = 0;
        for(int interval[] : intervals) {
            startTimes[count] = interval[0];
            endTimes[count++] = interval[1];
        }
        
        Arrays.sort(startTimes);
        Arrays.sort(endTimes);
        
        int start = 0;
        int end = 0;
        int rooms = 0;
        while(start < intervals.length && end < intervals.length) {
            if(startTimes[start] >= endTimes[end]) {
                rooms--;
                end++;
            }
            rooms++;
            start++;
        }
        return rooms;
    }
}
// 2
// 0 5 15
// 10 20 30

// 1 13
// 13 15