class Solution {
    public boolean canReach(int[] arr, int start) {
        boolean[] vis = new boolean[arr.length];
        return dfs(arr,start,vis);
    }
    private boolean dfs(int[] arr,int st,boolean[] vis){
        
        if(st<0 || st>=arr.length || vis[st]){
            return false;
        }
        vis[st]=true;

        if(arr[st]==0) return true;

        int next = st+arr[st];
        int prev = st-arr[st];
    
        return dfs(arr,next,vis) || dfs(arr,prev,vis);
    }
}