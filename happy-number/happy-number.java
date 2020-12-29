class Solution {
    public boolean isHappy(int n) {
        int sum = 0;
        int count = 0;
        while(n > 0) {
            if(n == 1) return true;
            while(n > 0) {
                sum += (n % 10) * (n % 10);
                n = n / 10;
            }
            n = sum;
            sum = 0;
            System.out.println(n);
            if(n < 10) {
                if(count != 0) break;
                count++;
            }
        }
        return (n == 1);
    }
}
