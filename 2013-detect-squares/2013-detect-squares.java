class DetectSquares {
    class Params {
        int x;
        int y;
        public Params(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    HashMap<Pair<Integer, Integer>, Integer> map;
    List<Params> list;
    public DetectSquares() {
        this.map = new HashMap<>();
        this.list = new ArrayList<>();
    }
    
    public void add(int[] point) {
        Params param = new Params(point[0], point[1]);
        Pair<Integer, Integer> p = new Pair<>(point[0], point[1]);
        map.put(p, map.getOrDefault(p, 0) + 1);
        list.add(param);
    }
    
    public int count(int[] point) {
        if(map.size() < 3) return 0;
        int count = 0;
        int px = point[0];
        int py = point[1];
        for(Params points : list) {
            int x = points.x;
            int y = points.y;
            if(Math.abs(x - px) == Math.abs(y - py) && x != px && y != py) {
                //System.out.println(x + " " + y);
                if(map.containsKey(new Pair(x, py)) && map.containsKey(new Pair(px, y))) {
                 count += map.get(new Pair(x, py)) * map.get(new Pair(px, y));  
                 
                }
            }
        }
        return count;
    }
}

/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */