class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int[] parents = new int[edges.length + 1];
        int[] rank = new int[edges.length + 1];
        Arrays.fill(rank, 1);
        for(int i = 0; i < parents.length; ++i) {
            parents[i] = i;
        }
        for(int[] nodes : edges) {
            if(!union(parents, rank, nodes[0], nodes[1])) {
                return nodes;
            }
        }
        return edges[edges.length - 1];
    }
    public int findParent(int[] parents, int node) {
        int parent = parents[node];
        while(parent != parents[parent]) {
            parents[parent] = parents[parents[parent]];
            parent = parents[parent];
        }
        return parent;
    }
    public boolean union(int[] parents, int[] rank, int i, int j) {
        int parent_i = findParent(parents, i);
        int parent_j = findParent(parents, j);
        if(parent_i == parent_j) {
            return false;
        }
        if(rank[parent_i] > rank[parent_j]) {
            parents[parent_j] = parent_i;
            rank[parent_i] += 1;
        }
        else {
            parents[parent_i] = parent_j;
            rank[parent_j] += 1;
        }
        return true;
    }
}
