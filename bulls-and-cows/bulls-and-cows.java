class Solution {
    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        List<Character> pond = new ArrayList();
        List<Character> pond1 = new ArrayList();
        for(int i = 0; i < secret.length(); ++i) {
            if(secret.charAt(i) == guess.charAt(i)) {
                bulls++;
                continue;
            }
            else {
                pond.add(secret.charAt(i));
                pond1.add(guess.charAt(i));
                if(pond.contains(guess.charAt(i))) {
                    cows++;
                    pond.remove(new Character(guess.charAt(i)));
                    pond1.remove(new Character(guess.charAt(i)));
                }
                if(pond1.contains(secret.charAt(i))) {
                    cows++;
                    pond.remove(new Character(secret.charAt(i)));
                    pond1.remove(new Character(secret.charAt(i)));
                }
            }
        }
        String result = Integer.toString(bulls) + "A" + Integer.toString(cows) + "B";
        return result;
    }
}

// pond  9 6 2
// pond1 7 2 3 6