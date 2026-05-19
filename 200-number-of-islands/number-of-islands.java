class Solution {
    int[][] dirs = {{-1,0},{0,-1},{1,0},{0,1}};

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int cnt=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    dfs(grid,i,j);
                    cnt++;
                }
            }
        }    
        return cnt;
    }

    private void dfs(char[][] grid,int row,int col){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{row,col});
        grid[row][col]='#';

        while(!q.isEmpty()){
            

            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];

            for(int[] dir:dirs){

                int nr = r+dir[0];
                int nc = c+dir[1];

                if(nr>=0 && nr<grid.length && nc>=0 && nc<grid[0].length && grid[nr][nc]=='1'){
                    grid[nr][nc]='#';
                    q.offer(new int[]{nr,nc});                    
                }

            }
        }

       
    }
}