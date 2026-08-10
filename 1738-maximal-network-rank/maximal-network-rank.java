class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        int[] deg = new int[n];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<roads.length;i++){
            int u = roads[i][0];
            int v = roads[i][1];

            adj.get(u).add(v);
            adj.get(v).add(u);
            deg[u]++;
            deg[v]++;
        }
        int maxrank=0;
       for(int i=0;i<n-1;i++){
        for(int j=i+1;j<n;j++){
            int rank = deg[i]+deg[j];
            if(adj.get(i).contains(j)) rank--;
            maxrank = Math.max(maxrank,rank);
        }
       }
       return maxrank;


    }
}