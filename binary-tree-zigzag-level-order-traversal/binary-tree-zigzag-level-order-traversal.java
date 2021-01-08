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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList();
        Stack<TreeNode> s1 = new Stack();
        Stack<TreeNode> s2 = new Stack();
        if(root == null) return result;
        s1.push(root);
        List<Integer> sub_res = new ArrayList();
        while(!s1.isEmpty() || !s2.isEmpty()) {
            while(!s1.isEmpty()) {
                TreeNode newnode = new TreeNode();
                newnode = s1.pop();
                sub_res.add(newnode.val);
                if(newnode.left != null) {
                    s2.push(newnode.left);
                }
                if(newnode.right != null) {
                    s2.push(newnode.right);
                }
            }
            result.add(new ArrayList(sub_res));
            sub_res.clear();
            
            while(!s2.isEmpty()) {
                TreeNode newnode = new TreeNode();
                newnode = s2.pop();
                sub_res.add(newnode.val);
                if(newnode.right != null) {
                    s1.push(newnode.right);
                }
                if(newnode.left != null) {
                    s1.push(newnode.left);
                }
            }
            result.add(new ArrayList(sub_res));
            sub_res.clear();
        }
        if(result.get(result.size() - 1).size() == 0) result.remove(result.size() - 1);
        return result;
    }
}
