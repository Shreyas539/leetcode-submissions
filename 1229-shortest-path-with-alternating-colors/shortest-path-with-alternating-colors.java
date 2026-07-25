class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        List<List<Integer>> graphR = new ArrayList<>();
        List<List<Integer>> graphB = new ArrayList<>();

        for(int i=0;i<n;i++){
            graphR.add(new ArrayList<>());
            graphB.add(new ArrayList<>());
        }

        for (int[] edge : redEdges) {
            graphR.get(edge[0]).add(edge[1]);
        }

        for (int[] edge : blueEdges) {
            graphB.get(edge[0]).add(edge[1]);
        }

        int[] ans  = new int[n];
        Arrays.fill(ans,-1);

        boolean[][] vis = new boolean[n][2];
        Queue<int[]> q = new LinkedList<>();
        // 0:redEdge
        // 1:blueEdge
        q.offer(new int[]{0,0});
        q.offer(new int[]{0,1});
        vis[0][0]=true;
        vis[0][1]=true;
        int dist=0;

        while(!q.isEmpty()){
            int len = q.size();

            for(int i=0;i<len;i++){
                int[] cur = q.poll();
                int node = cur[0];
                int lstColor = cur[1];

                if(ans[node]==-1){
                    ans[node] = dist;
                }
                if(lstColor==0){
                    for(int next:graphB.get(node)){
                        if(!vis[next][1]){
                            vis[next][1] = true;
                            q.offer(new int[]{next,1});
                        }
                    }
                }else{
                    for(int next:graphR.get(node)){
                        if(!vis[next][0]){
                            vis[next][0] = true;
                            q.offer(new int[]{next,0});
                        }
                    }
                }
            }
            dist++;
        }
        return ans;
    }
}