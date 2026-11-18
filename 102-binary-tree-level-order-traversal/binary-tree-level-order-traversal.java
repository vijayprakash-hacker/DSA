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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();

        if(root == null) {
            return list;
        }

        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);
        q.add(null);

        while(!q.isEmpty()) {
            TreeNode currNode = q.remove();

            if(currNode == null) {
                list.add(list1);
                
                if(q.isEmpty()) {
                    break;
                } else {
                    list1 = new ArrayList<>();
                    q.add(null);
                }
            } else {
                list1.add(currNode.val);

                if(currNode.left != null) {
                    q.add(currNode.left);
                }

                if(currNode.right != null) {
                    q.add(currNode.right);
                }
            }
        }

        return list;
    }
}