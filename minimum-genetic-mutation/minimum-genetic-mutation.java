class Solution {
    public final char[] choices = {'A', 'C', 'G', 'T'};
    public int minMutation(String start, String end, String[] bank) {
        HashSet<String> set = new HashSet();
        for(String s: bank) {
            set.add(s);
        }
        if(!set.contains(end)) return -1;
        return bfs(start, end, set);
    }
    public int bfs(String start, String end, HashSet<String> bank) {
        int steps = 1;
        HashSet<String> visited = new HashSet();
        Queue<String> queue = new ArrayDeque();
        queue.add(start);
        while(!queue.isEmpty()) {
            int k = queue.size();
            for(int j = 0; j < k; ++j) {
                char[] mutation = queue.poll().toCharArray();
                for(int i = 0; i < mutation.length; ++i) {
                char c = mutation[i];
                for(char choice: choices) {
                    if(choice == c) continue;
                    mutation[i] = choice;
                    String candidate = String.valueOf(mutation);
                    if(candidate.equals(end)) return steps;
                    if(bank.contains(candidate) && !visited.contains(candidate)) {
                        visited.add(candidate);
                        queue.add(candidate);
                    }
                }
                mutation[i] = c;
            }
            }
            steps++;
        }
        return -1;
    }
}