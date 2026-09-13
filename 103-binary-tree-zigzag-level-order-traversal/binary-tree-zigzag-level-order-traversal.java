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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if(root==null){
            return result;
        }

        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        boolean reverse=false;

        while(!deque.isEmpty()){
            int currentsize = deque.size();
            List<Integer> subresult = new ArrayList<>();

            for(int i=0;i<currentsize;i++){
                if(!reverse){
                    TreeNode currentElement = deque.pollFirst();
                    subresult.add(currentElement.val);
                    if(currentElement.left!=null){
                        deque.addLast(currentElement.left);
                    }
                    if(currentElement.right!=null){
                        deque.addLast(currentElement.right);
                    }
                }else{
                    TreeNode currentElement = deque.pollLast();
                    subresult.add(currentElement.val);
                    if(currentElement.right!=null){
                        deque.addFirst(currentElement.right);
                    }
                    if(currentElement.left!=null){
                        deque.addFirst(currentElement.left);
                    }
                }
            }
            reverse=!reverse;
            result.add(subresult);
        }
        return result;
    }
}