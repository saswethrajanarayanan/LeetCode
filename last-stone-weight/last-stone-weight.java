class Solution {
    public int lastStoneWeight(int[] stones) {
        Arrays.sort(stones);
        int right = stones.length - 1;
        int left = stones.length - 2;
        for(int i = stones.length - 1; i > 0; --i) {
            right = i;
            left = i - 1;
            int res = stones[right] - stones[left];
            stones[right] = 0;
            stones[left] = res;
            while(left > 0 && stones[left] < stones[left - 1]) {
                int data = stones[left];
                stones[left] = stones[left - 1];
                stones[left - 1] = data;
                left = left - 1;
            }
        }
        return stones[0];
    }
}


// 1 1 2 4 7 8
// 1 1 2 4 1 0             1 1 1 2 4 0
//                         1 1 1 2 0 0
//                         1 1 1 0 0 0
//                         1 0 0 0 0 0
                        