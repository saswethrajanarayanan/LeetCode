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
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        List<Integer> result = new ArrayList();
        dfs(result, root, 1);
        int max = result.get(0);
        for(int item : result) {
            max = Math.max(max, item);
        }
        return max;
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
