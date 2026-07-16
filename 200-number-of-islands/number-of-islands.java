class Solution {
        int res=0;
        int[][] dir = {{-1,0},{0,-1},{1,0},{0,1}};

    public int numIslands(char[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    res++;
                    bfs(grid,i,j,m,n);
                }
            }
        }
        return res;
    }
    private void bfs(char[][] grid,int row,int col,int m,int n){
        if(row<0 || col<0 || row>=m || col>=n || grid[row][col]=='0'){
            return;
        }

        grid[row][col]='0';

        for(int[] d:dir){
            int nr = row+d[0];
            int nc = col+d[1];
            bfs(grid,nr,nc,m,n);
        }
    }
}