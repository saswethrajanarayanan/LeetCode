class Solution {
    public String multiply(String num1, String num2) {
        int[] result = new int[num1.length() + num2.length()];
        Arrays.fill(result, 0);
        for(int i = num1.length() - 1; i >= 0; --i) {
            for(int j = num2.length() - 1; j >= 0; --j) {
                int product = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int sum = result[i + j + 1] + product;
                result[i + j + 1] = sum % 10;
                result[i + j] += sum / 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int key : result) { 
            if(sb.length() != 0 || key != 0){
                sb.append(key);
            }
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
