class Solution {
    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        if( jug1Capacity + jug2Capacity < targetCapacity)
            return false;
        
        int x = gcd(jug1Capacity,jug2Capacity);
        
        if(targetCapacity % x == 0  )
            return true;
        
        return false;
    }
    
    private static int gcd(int x,int y) {
        
        while( y != 0 ) {
            
            if( x > y)
                x -= y;
            else
                y -= x;
            
        }
        return x;
    }
}