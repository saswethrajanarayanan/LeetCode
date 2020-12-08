/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        List<Integer> result = new ArrayList();
        int count = 1;
        dfs(result, root, count);
        int min = result.get(0);
        if(result.size() == 1) return result.get(0);
        System.out.println(result);
        for(int i = 0; i < result.size(); ++i) {
            min = Math.min(min, result.get(i));
        }
        return min;
    }
    private void dfs(List<Integer> result, TreeNode root, int count) {
        if(root == null) return;
        
        if(root.left == null && root.right == null) {
            result.add(count);
            return;
        }
        dfs(result, root.left, count + 1);
        dfs(result, root.right, count + 1);
    }
}
