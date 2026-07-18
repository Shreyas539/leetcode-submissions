class Solution {
    int[][] memo;
    int row ,col;
    int[][] dir = {{-1,0},{0,-1},{1,0},{0,1}};
    public int longestIncreasingPath(int[][] matrix) {
        row = matrix.length;
        col = matrix[0].length;
        memo = new int[row][col];

        int maxpath = 1;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                maxpath = Math.max(maxpath,dfs(matrix,i,j));
            }
        }
        return maxpath;
    }
    private int dfs(int[][] matrix,int r,int c){
        if(memo[r][c]!=0) return memo[r][c];

        int best = 1;
        for(int[] d:dir){
            int nr = r+d[0];
            int nc = c+d[1];

            if(nr>=0 && nc>=0 && nr<row && nc<col && matrix[nr][nc]>matrix[r][c]){
                best = Math.max(best,1+ dfs(matrix,nr,nc));
            }
        }
        memo[r][c] = best;
        return best;

    }
}