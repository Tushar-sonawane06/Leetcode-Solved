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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> lsit = new ArrayList<>();

        preorder(lsit, root);

        return lsit;
    }

    public void preorder(List<Integer> lsit, TreeNode root){
        if(root==null){
            return;
        }

        lsit.add(root.val);
        preorder(lsit,root.left);
        preorder(lsit,root.right);
    }
}