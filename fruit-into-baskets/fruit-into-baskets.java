class Solution {
    public int totalFruit(int[] tree) {
        int count = 0;
        int max = 0;
        int first = tree[0];
        int second = tree.length + 1;
        int firstindex = 0;
        int secondindex = 0;
        for(int i = 0; i < tree.length; ++i) {
            if(first == tree[i]) {
                firstindex = i;
                count++;
            }
            else if(first != tree[i] && second == tree.length + 1) {
                second = tree[i];
                secondindex = i;
                count++;
            }
            else if(second == tree[i]) {
                secondindex = i;
                count++;
            }
            else if(first != tree[i] && second != tree[i]) {
                max = Math.max(max, count);
                if(tree[i - 1] == first) {
                    second = tree[i];
                    count = i - secondindex;
                    secondindex = i;
                } 
                if(tree[i - 1] == second) {
                    first = tree[i];
                    count = i - firstindex;
                    firstindex = i;
                }
            }
            
        }
        return Math.max(max, count);
    }
}
