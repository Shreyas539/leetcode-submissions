class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        int[][] count = new int[n][26];
        int[] indeg = new int[n];

        List<List<Integer>> adj = new ArrayList<>();
        for (int i=0; i<n; i++) adj.add(new ArrayList<>());
        for(int[] edge:edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            indeg[v]++;
        }

        int ans = Integer.MIN_VALUE;
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indeg[i]==0){
                q.offer(i);
            }
        }
        int vis = 0;


        while(!q.isEmpty()){
            int node = q.poll();
            vis++;
            int colorIdx = colors.charAt(node)-'a';
            count[node][colorIdx]++;
            ans = Math.max(ans,count[node][colorIdx]);

            for(int nei:adj.get(node)){
                for(int i=0;i<26;i++){

                    count[nei][i] = Math.max(count[nei][i],count[node][i]);
                }
                indeg[nei]--;

                if(indeg[nei]==0){
                    q.offer(nei);
                }
            }
        }
        return vis == n ? ans : -1;

    }
}