class RandomizedSet {
    HashMap<Integer, Integer> map;
    List<Integer> list;
    Random rand = new Random();
    public RandomizedSet() {
        this.map = new HashMap<>();
        this.list = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if(!map.containsKey(val)) {
            map.put(val, list.size());
            list.add(list.size(), val);
            return true;
        }
        return false;
    }
    
    public boolean remove(int val) {
        if(map.containsKey(val)) {
            int pos = map.get(val);
            int replacement = list.get(list.size() - 1);
            list.set(pos, replacement);
            list.remove(list.size() - 1);
            map.put(replacement, pos);
            map.remove(val);
            return true;
        }
        return false;
    }
    
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */