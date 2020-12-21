class Solution {
    public int numUniqueEmails(String[] emails) {
        int atPresent = 0;
        String email = "";
        HashMap<String, Integer> map = new HashMap();
        for(int i = 0; i < emails.length; ++i) {
            String current = emails[i];
            email = "";
            atPresent = 0;
            for(int j = 0; j < current.length(); ++j) {
                if(current.charAt(j) == '@') {
                    atPresent = 1;
                }
                if(current.charAt(j) == '.'&& atPresent == 0) continue;
                if(current.charAt(j) == '+' && atPresent == 0) {
                    while(current.charAt(j + 1) != '@') {
                        j++;
                    }
                    continue;
                }
                email += current.charAt(j);
            }
            if(map.containsKey(email)) map.put(email, map.get(email) + 1);
            else map.put(email, 1);
        }
        int count = 0;
        for(Map.Entry<String, Integer> hmap : map.entrySet()) {
            count++;
            System.out.println(hmap.getKey());
        }
        return count;
    }
}
