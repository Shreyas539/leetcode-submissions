class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] dist = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.offer(new int[]{k,0});
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge:times){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            adj.get(u).add(new int[]{v,w});
        }

        dist[k]=0;

        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int node = cur[0];
            int curDist = cur[1];

            if(curDist>dist[node]) continue;

           for (int[] nei : adj.get(node)) {
                int next = nei[0], w = nei[1];
                int newDist = curDist + w;
                if (newDist < dist[next]) {
                    dist[next] = newDist;
                    pq.offer(new int[]{next, newDist});
                }
            }
        }

        int ans = 0;

        for(int i=1;i<=n;i++){
            if(dist[i]==Integer.MAX_VALUE) return -1;
            ans = Math.max(ans,dist[i]);
        }
        return ans;
    }
}