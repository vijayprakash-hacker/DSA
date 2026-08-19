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
    public boolean isSymmetric(TreeNode root) {
        return symmetric(root.left, root.right);
    }

    private boolean symmetric(TreeNode lh, TreeNode rh) {
        if ((lh == null && rh != null) || lh != null && rh == null) {
            return false;
        } else if (lh == null && rh == null) {
            return true;
        }

        return symmetric(lh.left, rh.right) && symmetric(lh.right, rh.left)
                && lh.val == rh.val;
    }
}