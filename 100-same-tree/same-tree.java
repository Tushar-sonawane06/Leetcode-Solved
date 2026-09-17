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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return helper(p,q);
    }
    public boolean helper(TreeNode proot,TreeNode qroot){
        if(proot==null && qroot==null){
            return true;
        }
        if(proot==null || qroot==null){
            return false;
        }

        if(proot.val!=qroot.val){
            return false;
        }

        return helper(proot.left,qroot.left) && helper(proot.right, qroot.right);
    }
}