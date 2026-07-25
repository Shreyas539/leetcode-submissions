class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] vis = new boolean[rooms.size()];
        dfs(rooms,vis,0);

        for(boolean i:vis){
            if(!i) return false;
        }
        return true;
    }
    private void dfs(List<List<Integer>> rooms,boolean[] vis,int room){
        if(vis[room]) return;

        vis[room] = true;

        for(int nei:rooms.get(room)){
            dfs(rooms,vis,nei);
        }
    }
}