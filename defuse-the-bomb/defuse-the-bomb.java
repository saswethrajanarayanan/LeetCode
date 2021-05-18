class Solution {
    public int[] decrypt(int[] code, int k) {
        int[] result = new int[code.length];
        for(int i = 0; i < code.length; ++i) {
            if(k > 0) {
                for(int j = 1; j <= k; ++j) {
                    if(i + j > code.length - 1) {
                        result[i] += code[i + j - code.length];
                    }
                    else {
                        result[i] += code[i + j];
                    }
                }
            }
            else if(k < 0) {
                for(int j = -1; j >= k; --j) {
                    if(i + j < 0) {
                        result[i] += code[i + j + code.length];
                    }
                    else {
                        result[i] += code[i + j];
                    }
                }
            }
            else {
                result[i] = 0;
            }
        }
        return result;
    }
}