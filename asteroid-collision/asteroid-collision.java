class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack();
        for(int i = 0; i < asteroids.length; ++i) {
            if(asteroids[i] > 0) {
                stack.push(asteroids[i]);
            }
            else {
                while(!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(asteroids[i])) {
                    stack.pop();
                }
                if(stack.isEmpty() || stack.peek() < 0) {
                    stack.push(asteroids[i]);
                }
                else if(stack.peek() == Math.abs(asteroids[i])) {
                    stack.pop();
                }
            }
        }
        int[] remaining = new int[stack.size()];
        for(int i = remaining.length - 1; i >= 0; --i) {
            remaining[i] = stack.pop();
        }
        return remaining;
    }
}