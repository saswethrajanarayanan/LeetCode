class Solution {
    int totalTime = 0;
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        HashMap<Integer, List<Integer>> adjList = new HashMap<>();
        for(int i = 0; i < manager.length; ++i) {
            int managerCurrent = manager[i];
            if(!adjList.containsKey(managerCurrent)) {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                adjList.put(managerCurrent, list);
            }
            else {
                adjList.get(managerCurrent).add(i);
            }
        }
        dfs(headID, adjList, informTime, 0, new boolean[manager.length]);
        return totalTime;
    }
    public void dfs(int headID, HashMap<Integer, List<Integer>> adjList, int[] informTime, int time, boolean[] visited) {
        if(visited[headID]) {
            return;
        }
        visited[headID] = true;
        time += informTime[headID];
        totalTime = Math.max(totalTime, time);
        if(adjList.containsKey(headID)) {
            for(int i = 0 ; i < adjList.get(headID).size(); ++i) {
                int current = adjList.get(headID).get(i);
                dfs(current, adjList, informTime, time, visited);
            }
        }
        return;
    }
}