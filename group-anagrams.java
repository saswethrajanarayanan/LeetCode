class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>>result = new ArrayList();
        if(strs.length == 0) return result;
        String[] nums = new String[strs.length];
        int[] marked = new int[strs.length];
        Arrays.fill(marked, 0);
        for(int i = 0; i < strs.length; ++i) {
            nums[i] = sortString(strs[i]);
            //System.out.println(nums[i]);
        }
        for(int i = 0; i < strs.length; ++i) {
            if(marked[i] == 1) continue;
            List<String> sub_res = new ArrayList();
            sub_res.add(strs[i]);
            if(i == strs.length - 1) {
                result.add(sub_res);
                break;
            }
            for(int j = i + 1; j < strs.length; ++j) {
                //System.out.println(nums[i] + "-" + nums[j] + "-" + marked[j]);
                if(nums[i].equals(nums[j]) && marked[j] == 0) {
                    //System.out.println("Here now");
                    sub_res.add(strs[j]);
                    marked[j] = 1;
                }
            }
            result.add(sub_res);
        }
        return result;
    }
    private String sortString(String s) {
        char[] tempArray = s.toCharArray();
        Arrays.sort(tempArray);
        return new String(tempArray);
    }
}
