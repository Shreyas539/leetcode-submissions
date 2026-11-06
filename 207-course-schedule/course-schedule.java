class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
        List<List<Integer>> gp = new ArrayList<>();

        for(int i=0;i<n;i++){
            gp.add(new ArrayList<>());
        }

        for(int[] edge:prerequisites){
            int u = edge[1];
            int v = edge[0];

            gp.get(u).add(v);
            
        }
        int[] vis = new int[n];

        for(int[] edge:prerequisites){
            if(dfs(edge[1],gp,vis)){
                return false;
            }
        }
        return true;
    }
    private boolean dfs(int node,List<List<Integer>> gp,int[] vis){
        if(vis[node]==1) return true;
        if(vis[node]==2) return false;
        
        vis[node] = 1;

        for(int nei:gp.get(node)){
            if(dfs(nei,gp,vis)){
                return true;
            }
        }

        vis[node]=2;
        return false;
    }
}
