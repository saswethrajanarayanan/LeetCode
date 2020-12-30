class Solution {
    public boolean canCross(int[] stones) {
        for(int i = 3; i < stones.length; ++i) {
            if(stones[i] > stones[i - 1] * 2) {
               return false;
            }
        }
        
        Stack<Integer> jumps = new Stack();
        Stack<Integer> positions = new Stack();
        HashSet<Integer> stonepos = new HashSet();
        for(int stone : stones) {
            stonepos.add(stone);
        }
        jumps.add(0);
        positions.add(0);
        while(!positions.isEmpty()) {
            int position = positions.pop();
            int jumpdistance = jumps.pop();
            for(int i = jumpdistance - 1; i <= jumpdistance + 1; ++i) {
                if(i <= 0) continue;
                int nextpos = position + i;
                if(nextpos == stones[stones.length - 1]) return true;
                else if(stonepos.contains(nextpos)) {
                        positions.add(nextpos);
                        jumps.add(i);
                    }
            }
        }
        return false;
    }
}
