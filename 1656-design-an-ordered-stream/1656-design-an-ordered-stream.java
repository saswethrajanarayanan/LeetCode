class OrderedStream {
    String[] result;
    int helper;
    PriorityQueue<Integer> minHeap;
    public OrderedStream(int n) {
        this.result = new String[n + 1];
        this.helper = 0;
        Arrays.fill(result, "");
        this.minHeap = new PriorityQueue<>();
        for(int i = 1; i <= n; ++i) {
            minHeap.add(i);
        }
    }
    
    public List<String> insert(int idKey, String value) {
        List<String> ret = new ArrayList<>();
        result[idKey] = value;
        if(minHeap.peek() < idKey) {
            minHeap.remove(idKey);
            return ret; 
        }
        for(int i = idKey; i < result.length; ++i) {
            if(result[i] != "") {
                ret.add(result[i]);
            }
            else break;
        }
        minHeap.remove(idKey);
        return ret;
    }
}

/**
 * Your OrderedStream object will be instantiated and called as such:
 * OrderedStream obj = new OrderedStream(n);
 * List<String> param_1 = obj.insert(idKey,value);
 */

// If 1 is empty, it doesnt matter if other spots are filled.
// If 1 is filled, you have to print or load intermediate value only if there is an adjacent position thats filled.