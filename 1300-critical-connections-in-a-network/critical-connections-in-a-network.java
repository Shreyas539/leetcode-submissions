class Solution {
    private int time;
    private List<List<Integer>> adj;
    private int[] disc, low;
    private List<List<Integer>> bridges;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {

        adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(List<Integer> edge:connections){
            int u = edge.get(0),v=edge.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        bridges = new ArrayList<>();
        disc = new int[n];
        low = new int[n];
        Arrays.fill(disc,-1);
        Arrays.fill(low,-1);
    
        time =0;
        dfs(0,-1);
        return bridges;
    }
    private void dfs(int u,int parent){
        disc[u] = low[u] = time++;
        
        for(int v:adj.get(u)){
            if(v==parent) continue;
            if(disc[v]==-1){
                dfs(v,u);
                low[u] = Math.min(low[v],low[u]);
                if(low[v]>disc[u]){
                    bridges.add(Arrays.asList(u,v));
                }
            }else{
                low[u] = Math.min(low[u],disc[v]);
            }
        }
    }
}