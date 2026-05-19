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
        if(grid[row][col]=='0') return;
        char temp = grid[row][col];
        grid[row][col] = '#';

        for(int[] dir:dirs){
            int nr = row+dir[0];
            int nc = col+dir[1];

            if(nr>=0 && nr<grid.length && nc>=0 && nc<grid[0].length && grid[nr][nc]=='1'){
                
                dfs(grid,nr,nc);
            }

        }

       
    }
}