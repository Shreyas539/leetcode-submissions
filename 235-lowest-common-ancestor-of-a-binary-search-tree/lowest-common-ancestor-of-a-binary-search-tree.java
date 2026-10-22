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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        while(!queue.isEmpty()){
            TreeNode node  = queue.poll();

            if(p.val<node.val && q.val<node.val){
                if(node.left!=null){
                    queue.offer(node.left);
                }
            }else if(p.val>node.val && q.val>node.val){
                if(node.right!=null){
                    queue.offer(node.right);
                }
            }else{
                return node;
            }
        }

        return null;
    }
}