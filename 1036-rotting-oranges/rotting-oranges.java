class Solution {
    int[][] dirs = {{-1,0},{0,-1},{1,0},{0,1}};
    int m;
    int n;
    int ans=0;
    public int orangesRotting(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        int rottenCnt = 0;
        int freshCnt = 0;
        Queue<int[]> q = new LinkedList<>();
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                   rottenCnt++;
                   q.offer(new int[]{i,j,0});
                }else if(grid[i][j]==1){
                    freshCnt++;
                }
            }
        }

        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int step = cur[2];
            ans = Math.max(ans,step);

            for(int[] dir:dirs){
                int nr = dir[0]+cur[0];
                int nc = dir[1]+cur[1];
                if(nr>=0 && nr<grid.length && nc>=0 && nc<grid[0].length && grid[nr][nc]==1){
                    q.offer(new int[]{nr,nc,step+1});
                    
                    freshCnt--;
                    grid[nr][nc]=2;
                }
            }

        }

        return freshCnt==0 ? ans : -1;

        
    }
    private void bfs(int[][] grid,int row,int col){
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{row,col,0});
        grid[row][col]=2;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int step = cur[2];
            ans = Math.max(ans,step);

            for(int[] dir:dirs){
                int nr = dir[0]+cur[0];
                int nc = dir[1]+cur[1];
                if(nr>=0 && nr<grid.length && nc>=0 && nc<grid[0].length && grid[nr][nc]==1){
                    q.offer(new int[]{nr,nc,step+1});
                    
                    // System.out.println(step);
                    grid[nr][nc]=2;
                }
            }

        }
    }
}