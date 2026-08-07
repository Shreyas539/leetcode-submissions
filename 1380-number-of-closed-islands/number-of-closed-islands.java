class Solution {
    int[][] dir= {{-1,0},{0,-1},{1,0},{0,1}};
    public int closedIsland(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;

        for(int i=0;i<m;i++){
            dfs(grid,i,0,m,n);
            dfs(grid,i,n-1,m,n);
        }

        for(int i=0;i<n;i++){
            dfs(grid,0,i,m,n);
            dfs(grid,m-1,i,m,n);
        }
        int ans=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0){
                    dfs(grid,i,j,m,n);
                    ans++;
                }
            }
        }
        return ans;
    }
    private void dfs(int[][] grid,int row,int col,int m,int n){
        if(row<0 || col<0 || row>=m || col>=n || grid[row][col]==1){
            return;
        }
        grid[row][col]=1;

        for(int[] d:dir){
            dfs(grid,row+d[0],col+d[1],m,n);
        }
    }
}