class Solution {
    int ans=0;
    public int minReorder(int n, int[][] connections) {
        
        List<List<Integer>> adj = new ArrayList<>();
        List<List<Integer>> directedGraph = new ArrayList<>();
        boolean[] vis = new boolean[n];

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
            directedGraph.add(new ArrayList<>());
        }


        for(int[] cur:connections){
            adj.get(cur[0]).add(cur[1]);
            adj.get(cur[1]).add(cur[0]);

            directedGraph.get(cur[0]).add(cur[1]);
        }

        dfs(adj,directedGraph,vis,0);

        return ans;
    }

    private void dfs(List<List<Integer>> adj,List<List<Integer>> directedGraph,boolean[] vis,int s){
        if(vis[s]) return;
        vis[s]=true;

        for(int nbrs:adj.get(s)){
            if(!vis[nbrs]){
                if(directedGraph.get(s).contains(nbrs)) ans++;
                dfs(adj,directedGraph,vis,nbrs);
            }
        }
    }
}