class Solution {
    int[][] dir = {{-1,0},{0,-1},{1,0},{0,1}};

    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int[][] dist = new int[m][n];
        Queue<int[]> q = new LinkedList<>();

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0){
                    dist[i][j]=0;
                    q.offer(new int[]{i,j});
                }else{
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            

            for(int[] d:dir){
                int nr = r+d[0];
                int nc = c+d[1];
                if(nr>=0 && nc>=0 && nr<m && nc<n) {
                    if(dist[nr][nc]>dist[r][c]+1){
                        dist[nr][nc]=dist[r][c]+1;
                        q.offer(new int[]{nr,nc});
                    }
                }
            }
        }
        return dist;
    }
    
}