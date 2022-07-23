class Solution {
    public int[] amountPainted(int[][] paint) {
        TreeMap<Integer, Integer> treemap = new TreeMap<>();
        int max = Integer.MIN_VALUE;
        for(int[] p : paint) {
            max = Math.max(p[1], max);
        }
        int[] area = new int[max + 1];
        int value = 1;
        for(int[] p: paint) {
            for(int i = p[0]; i < p[1]; ++i) {
                if(area[i] == 0) {
                    area[i] = value;
                }
            }
            value += 1;
        }
        for(int i = 0; i < area.length; ++i) {
            if(area[i] == 0) continue;
            treemap.put(area[i], treemap.getOrDefault(area[i], 0) + 1);
        }
        int[] areas = new int[paint.length];
        for(int i = 0; i < areas.length; ++i) {
            if(treemap.containsKey(i + 1)) {
                areas[i] = treemap.get(i + 1);
            }
        }
        return areas;
    }
}
// -1, 1, 1, 1, 3, 2, 2, 2, 
// 1 -> 3,
// 2 -> 3,
// 3 -> 1;

// -1, 1, 1, 1, 1;
// 1 -> 4;