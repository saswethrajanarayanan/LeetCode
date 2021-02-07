class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<List<Integer>> dp = new ArrayList();
        for(int i = 0; i < triangle.size(); ++i) {
            List<Integer> sub_res = new ArrayList(triangle.get(i));
            dp.add(sub_res);
            for(int j = 0; j < sub_res.size(); ++j) {
                if(i > 0) {
                    if(j == 0) {
                        dp.get(i).set(j, dp.get(i).get(j) + dp.get(i - 1).get(j));
                    }
                    else if(j == sub_res.size() - 1) {
                        dp.get(i).set(j, dp.get(i).get(j) + dp.get(i - 1).get(j - 1));
                    }
                    else {
                        dp.get(i).set(j, dp.get(i).get(j) + Math.min(dp.get(i - 1).get(j - 1), dp.get(i - 1).get(j)));
                    }
                }
            }
        }
        return Collections.min(dp.get(dp.size() - 1));
    }
}