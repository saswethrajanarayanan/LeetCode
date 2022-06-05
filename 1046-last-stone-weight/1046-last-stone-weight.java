class Solution {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int val : stones) {
            maxHeap.add(val);
        }
        while(!maxHeap.isEmpty()) {
            if(maxHeap.size() == 1) break;
            int first = maxHeap.peek();
            maxHeap.poll();
            int second = maxHeap.peek();
            maxHeap.poll();
            int leftOver = first - second;
            if(leftOver != 0) {
                maxHeap.add(leftOver);
            }
        }
        return maxHeap.size() == 0 ? 0 : maxHeap.peek();
    }
}