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
    public boolean isCousins(TreeNode root, int x, int y) {
        TreeNode xx = findnode(root,x);
        TreeNode yy = findnode(root,y);

        return (
            (level(root,xx,0)==level(root,yy,0)) && (!isSibling(root,xx,yy))
        );
    }
    public boolean isSibling(TreeNode root,TreeNode x,TreeNode y){
        if(root==null){
            return false;
        }

        return(
            (root.left==x && root.right==y) || (root.left==y && root.right==x) ||
            (isSibling(root.left,x,y)) || (isSibling(root.right,x,y))
        );
    }
    public int level(TreeNode root,TreeNode n,int lvl){
        if(root==null){
            return 0;
        }

        if(root==n){
            return lvl;
        }

        int n2 = level(root.left,n,lvl+1);
        if(n2!=0){
            return n2;
        }
        return level(root.right,n,lvl+1);
    }
    public TreeNode findnode(TreeNode root,int i){
        if(root==null){
            return null;
        }

        if(root.val==i){
            return root;
        }

        TreeNode n = findnode(root.left,i);
        if(n!=null){
            return n;
        }
        return findnode(root.right,i);
    }
}