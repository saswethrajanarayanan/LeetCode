class Solution {
    public List<Long> maximumEvenSplit(long finalSum) {
        List<Long> list = new ArrayList<>();
        if(finalSum % 2 != 0) {
            return list;
        }
        
        long current_num = 2;
        long current_sum = 0;
        HashMap<Long, Integer> map = new HashMap<>();
        while(current_sum < finalSum) {
            current_sum += current_num;
            list.add(current_num);
            map.put(current_num, list.size() - 1);
            current_num += 2;
        }
        if(current_sum == finalSum) return list;
        long x = current_sum - finalSum;
        int removal = map.get(x);
        list.remove(removal);
        return list;
    }
}
// 2 2;
// 4 4;
// 6 6;
// 8 8;

