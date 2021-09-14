class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int modulo = (int) Math.pow(10, 9) + 7 ;
        List<Pair<Integer, Integer>> candidates = new ArrayList();
        for(int i = 0; i < speed.length; ++i) {
            candidates.add(new Pair(efficiency[i], speed[i]));
        }
        Collections.sort(candidates, Comparator.comparing(o -> -o.getKey()));
        PriorityQueue<Integer> minHeap = new PriorityQueue();
        
        long perf = 0;
        long totalSpeed = 0;
        for(Pair<Integer, Integer> candidate : candidates) {
            int currentEfficiency = candidate.getKey();
            int currentSpeed = candidate.getValue();
            while(minHeap.size() > k - 1) {
                totalSpeed -= minHeap.remove();
            }
            minHeap.add(currentSpeed);
            totalSpeed += currentSpeed;
            perf = Math.max(perf, totalSpeed * currentEfficiency);            
        }
        return (int) (perf % modulo);
    }
}