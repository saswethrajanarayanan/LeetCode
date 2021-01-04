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
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        List<Integer> target = new ArrayList();
        btrack(root, target);
        target.add(val);
        int max = target.get(0);
        int index = 0;
        for(int i = 0; i < target.size(); ++i) {
            if(max < target.get(i)) {
                index = i;
                max = target.get(i);
            }
        }
        TreeNode root1 = new TreeNode();
        root1.val = max;
        root1.left = newTree(target, 0, index - 1);
        root1.right = newTree(target, index + 1, target.size() - 1);
        return root1;
    }
    private void btrack(TreeNode root, List<Integer> temp) {
        if(root == null) return;
        
        btrack(root.left, temp);
        temp.add(root.val);
        btrack(root.right, temp);
        return;
    }
    private TreeNode newTree(List<Integer> target, int min, int max) {
        if(min > max) return null;
        TreeNode root = new TreeNode();
        int maximum = target.get(min);
        int index = min;
        for(int i = min; i <= max; ++i) {
            if(maximum < target.get(i)) {
                maximum = target.get(i);
                index = i;
            } 
        }
        root.val = maximum;
        root.left = newTree(target, min, index - 1);
        root.right = newTree(target, index + 1,  max);
        return root;
    }
}
