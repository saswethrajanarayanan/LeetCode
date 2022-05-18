class Solution {
    public int[][] merge(int[][] intervals) {
        int[] lower = new int[intervals.length];
        int[] upper = new int[intervals.length];
        List<int[]> mergedIntervals = new ArrayList<>();
        int count = 0;
        
        for(int i = 0; i < intervals.length; ++i) {
            lower[i] = intervals[i][0];
            upper[i] = intervals[i][1];
        }
        Arrays.sort(lower);
        Arrays.sort(upper);
        for(int i = 0; i < lower.length; ++i) {
            int[] subArray = new int[2];
            subArray[0] = lower[i];
            while(i < intervals.length - 1 && upper[i] >= lower[i + 1] && upper[i] <= upper[i + 1]) {
                i++;
            }
            // System.out.println(subArray[0]);
            subArray[1] = upper[i];
            mergedIntervals.add(subArray);
            count++;
        }
        return mergedIntervals.toArray(new int[count][2]);
    }
}

// 1 2 8 15;
// 3 6 10 18;
