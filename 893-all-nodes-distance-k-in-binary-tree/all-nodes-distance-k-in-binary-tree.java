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
    Map<TreeNode, TreeNode> map = new HashMap<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        putinmap(root,null);

        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> set=new HashSet<>();

        queue.offer(target);
        set.add(target);

        int distance=0;

        while(!queue.isEmpty()){
            if(distance==k){
                break;
            }

            int size = queue.size();

            for(int i=0;i<size;i++){
                TreeNode current = queue.poll();

                if(current.left!=null && !set.contains(current.left)){
                    queue.offer(current.left);
                    set.add(current.left);
                }
                if(current.right!=null && !set.contains(current.right)){
                    queue.offer(current.right);
                    set.add(current.right);
                }

                TreeNode parent = map.get(current);

                if(parent!=null && !set.contains(parent)){
                    queue.offer(parent);
                    set.add(parent);
                }
            }
            distance++;
        }

        List<Integer> list = new ArrayList<>();

        while(!queue.isEmpty()){
            list.add(queue.poll().val);
        }

        return list;
    }
    public void putinmap(TreeNode root,TreeNode parent){
        if(root==null){
            return;
        }

        map.put(root,parent);

        putinmap(root.left,root);
        putinmap(root.right,root);
    }
}