class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> adj = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        int n = graph.length;
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<graph[i].length;j++){
                adj.get(i).add(graph[i][j]);
            }
        }

        bc(adj,res,0,new ArrayList<>(),n);
        return res;
    }
    private void bc(List<List<Integer>> adj,List<List<Integer>> res,int node,List<Integer> cur,int n){
        cur.add(node);
        if(node==n-1){
            res.add(new ArrayList<>(cur));
            return;
        }

        

        for(int nei:adj.get(node)){
            
            bc(adj,res,nei,cur,n);
            cur.remove(cur.size()-1);
        }
    }
}