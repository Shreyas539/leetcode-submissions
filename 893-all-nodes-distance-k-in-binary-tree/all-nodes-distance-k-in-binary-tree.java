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
    Map<TreeNode,TreeNode> parent = new HashMap<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> res = new ArrayList<>();

        buildparent(root,null);
        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> vis = new HashSet<>();
        q.offer(target);
        vis.add(target);
        int dist=0;

        while(!q.isEmpty()){
            int len = q.size();

            if(dist==k){
                for(TreeNode node:q){
                    res.add(node.val);
                    
                }
                return res;
            }

            for(int i=0;i<len;i++){
                TreeNode cur = q.poll();

                if(cur.left!=null && !vis.contains(cur.left)){
                    vis.add(cur.left);
                    q.offer(cur.left);
                }
                if(cur.right!=null && !vis.contains(cur.right)){
                    vis.add(cur.right);
                    q.offer(cur.right);
                }
                TreeNode p = parent.get(cur);
                if(p!=null && !vis.contains(p)){
                    vis.add(p);
                    q.offer(p);
                }
            }
            dist++;
        }
        return res;
    }
    private void buildparent(TreeNode node,TreeNode par){
        if(node==null) return ;
        parent.put(node,par);
        buildparent(node.left,node);
        buildparent(node.right,node);
    }
}