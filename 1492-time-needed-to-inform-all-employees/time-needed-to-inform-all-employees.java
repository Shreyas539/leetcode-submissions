class Solution {
    int ans=0;
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<n;i++){
            if(manager[i]!=-1){
                adj.get(manager[i]).add(i);
            }
        }


        
        // Queue<int[]> q = new LinkedList<>();
        // q.offer(new int[]{headID,0});
        // int maxtime = 0;
        // while(!q.isEmpty()){
        //     int[] cur = q.poll();
        //     int id= cur[0];
        //     int time = cur[1];

        //     maxtime = Math.max(maxtime,time);

        //     for(int emp:adj.get(id)){
        //         q.offer(new int[]{emp,time+informTime[id]});
        //     }
        // }
        return dfs(adj,informTime,headID);
    }
    private int dfs(List<List<Integer>> adj,int[] it,int hid){
        int maxtime=0;

        for(int idx:adj.get(hid)){
            maxtime = Math.max(maxtime,dfs(adj,it,idx));
        }

        return maxtime+it[hid];
    }
}