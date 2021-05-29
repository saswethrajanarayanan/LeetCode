class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap();
        for(char c : tasks) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue(Collections.reverseOrder());
        maxHeap.addAll(map.values());
        int cycles = 0;
        while(!maxHeap.isEmpty()) {
            List<Integer> currentTasks = new ArrayList<>();
            for(int i = 0; i < n + 1; ++i) {
                if(!maxHeap.isEmpty()) {
                    currentTasks.add(maxHeap.remove());
                }
            }
            for(int updatedTaskFreq : currentTasks) {
                if(--updatedTaskFreq > 0) {
                    maxHeap.add(updatedTaskFreq);
                }
            }
            cycles += maxHeap.isEmpty() ? currentTasks.size() : n + 1;
        }
        return cycles;
    }
}