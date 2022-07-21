class Solution {
    class raceCarHelper {
        int position;
        int speed;
        int distance;
        public raceCarHelper(int pos, int speed, int dist) {
            this.position = pos;
            this.speed = speed;
            this.distance = dist;
        }
    }
    public int racecar(int target) {
        Queue<raceCarHelper> storage = new ArrayDeque<>();
        HashSet<String> visited = new HashSet<>();
        storage.add(new raceCarHelper(0, 1, 0));
        
        while(!storage.isEmpty()) {
            raceCarHelper helper = storage.poll();
            
            //if(visited.contains(helper)) continue;
            
            //visited.add(helper.position + " " + helper.speed);
            if(helper.position == target) return helper.distance;
            storage.add(new raceCarHelper(helper.position + helper.speed, helper.speed * 2, helper.distance + 1));
            if((target < (helper.position + helper.speed) && helper.speed > 0) || (target > (helper.position + helper.speed) && helper.speed < 0)) {
                helper.speed = helper.speed > 0 ? -1 : 1;
                storage.add(new raceCarHelper(helper.position, helper.speed, helper.distance + 1));
            }
            
        }
      return -1;  
    }
}