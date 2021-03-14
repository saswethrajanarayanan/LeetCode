/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int result = 0;
    public int sumNumbers(TreeNode root) {
        getSum(new ArrayList<Integer>(), root);
        return result;
    }
    private void getSum(List<Integer> sub_res, TreeNode root) {
        if(root == null) {
            return;
        }
        if(root.left == null && root.right == null) {
            sub_res.add(root.val);
            int sum = 0;
            for(int item : sub_res) {
                sum = (sum * 10) + item;
            }
            result += sum;
            System.out.println(result);
            sub_res.remove(sub_res.size() - 1);
            return;
        }
        sub_res.add(root.val);
        getSum(sub_res, root.left);
        getSum(sub_res, root.right);
        sub_res.remove(sub_res.size() -1);
    }
}