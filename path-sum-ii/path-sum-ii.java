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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList();
        List<Integer> sub_res = new ArrayList();
        btrack(result, sub_res, root, sum);
        return result;
    }
    private void btrack(List<List<Integer>> result, List<Integer> sub_res, TreeNode root, int sum) {
        if(root == null) return;
        else if(root.left == null && root.right == null && sum - root.val == 0) {
            sub_res.add(root.val);
            result.add(new ArrayList(sub_res));
            sub_res.remove(sub_res.size() - 1);
            return;
        }
        else {
            sub_res.add(root.val);
            btrack(result, sub_res, root.left, sum - root.val);
            btrack(result, sub_res, root.right, sum - root.val);
            sub_res.remove(sub_res.size() - 1);
        }
    }
}
