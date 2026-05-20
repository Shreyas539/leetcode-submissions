class Solution {
    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1},{1,1},{1,-1},{-1,1},{-1,-1}};
    
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
if (grid[0][0] == 1 || grid[n-1][n-1] == 1) return -1;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0,1});
        grid[0][0] = 1;

        while(!q.isEmpty()){
            
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            int dist = cur[2];

            if(r==m-1 && c==n-1) return dist;

            for(int[] dir:dirs){
                int nr = r+dir[0];
                int nc = c+dir[1];
                
                

                if(nr>=0 && nr<m && nc>=0 && nc<n && grid[nr][nc]==0){
                    grid[nr][nc]=1;
                    q.offer(new int[]{nr,nc,dist+1});
                }
            }
        }

        return -1;

        
        
    }
    
}