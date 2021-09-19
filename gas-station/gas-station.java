class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int currentStation = -1;
        int gasLeft = 0;
        boolean start = false;
        HashSet<Integer> set = new HashSet();
        for(int i = 0; i < gas.length; ++i) {
            gasLeft += gas[i];
            set.add(i);
            if(gasLeft >= cost[i]) {
                start = true;
                if(currentStation == i) break;
                if(currentStation == -1) currentStation = i;
                //costToTravel = cost[i];
                gasLeft -= cost[i];
            }
            else {
                gasLeft = 0;
                currentStation = -1;
                if(set.size() == gas.length) break;
                else start = false;
                if(start) break;
            }
            if(i == gas.length - 1) i = -1;
        }
        return currentStation;
    }
}