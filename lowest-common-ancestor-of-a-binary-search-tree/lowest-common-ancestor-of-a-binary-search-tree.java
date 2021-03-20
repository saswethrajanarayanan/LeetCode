/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    TreeNode result = new TreeNode();
    TreeNode pNode = null;
    TreeNode qNode = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        findLCA(root, p, q);
        if(qNode == null && pNode != null) {
            return pNode;
        }
        if(qNode != null && pNode == null) {
            return qNode;
        }
        return result;
    }
    private boolean findLCA(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return false;
        }
        if(root.val == q.val || root.val == p.val) {
            if(root.val == q.val) {
                qNode = root;
            }
            if(root.val == p.val) {
                pNode = root;
            }
            return true;
        }
        boolean left = findLCA(root.left, p, q);
        boolean right = findLCA(root.right, p, q);
        
        if(left && right) {
            result = root;
        }
        return (left || right);
    } 
}