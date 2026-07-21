class Solution {
    int[][] dir = {{-1,0},{0,-1},{1,0},{0,1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        for(int i=0;i<m;i++){
            dfs(heights,pacific,i,0,heights[i][0]);
        }
        for(int i=0;i<n;i++){
            dfs(heights,pacific,0,i,heights[0][i]);
        }
        for(int i=0;i<m;i++){
            dfs(heights,atlantic,i,n-1,heights[i][n-1]);
        }
        for(int i=0;i<n;i++){
            dfs(heights,atlantic,m-1,i,heights[m-1][i]);
        }
        List<List<Integer>> res= new ArrayList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(pacific[i][j] && atlantic[i][j]){
                    res.add(Arrays.asList(i,j));
                }
            }
        }
        return res;
    }
    private void dfs(int[][] heights,boolean[][] vis,int r,int c,int prevHeight){
        int m = heights.length,n=heights[0].length;

        if(r<0 || r>=m || c<0 || c>=n ||vis[r][c] || heights[r][c]<prevHeight){
            return;
        }

        vis[r][c]=true;

        for(int[] d:dir){
            int nr = r+d[0];
            int nc = c+d[1];
            dfs(heights,vis,nr,nc,heights[r][c]);
        }
    }
}