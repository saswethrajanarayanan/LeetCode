class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> s1 = new ArrayList();
        for(int i = 1; i <= n; ++i) {
            String p = "";
            if(i % 3 == 0) {
                p += "Fizz";
            }
            if(i % 5 == 0) {
                p += "Buzz";
            }
            else if(i % 3 != 0 && i % 5 != 0){
                p += Integer.toString(i);
            }
            s1.add(p);
        }
        return s1;
    }
}
