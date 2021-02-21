class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int prevStation = 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue(Collections.reverseOrder());
        int count = 0;
        
        for(int i = 0; i < stations.length; ++i) {
            startFuel = startFuel - (stations[i][0] - prevStation);
            prevStation = stations[i][0];
            while(startFuel < 0 && !maxHeap.isEmpty()) {
                startFuel += maxHeap.peek();
                maxHeap.poll();
                count++;
            }
            if(startFuel < 0) return -1;
            maxHeap.add(stations[i][1]);
        }
        while(startFuel < target - prevStation && !maxHeap.isEmpty()) {
            startFuel += maxHeap.peek();
            maxHeap.poll();
            count++;
        }
        if(startFuel < target - prevStation) return -1;
        return count;
    }
}