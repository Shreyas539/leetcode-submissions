class Solution {
    int m;
    int n;
    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    public void solve(char[][] board) {
        m = board.length;
        n = board[0].length;

       bfs(board);
        
    }

    private void bfs(char[][] board){
            
        Queue<int[]> q = new LinkedList<>();
        
        for(int i=0;i<m;i++){
            if(board[i][0]=='O') q.offer(new int[]{i,0});
            if(board[i][n-1]=='O') q.offer(new int[]{i,n-1});
        }
        for(int i=0;i<n;i++){
            if(board[0][i]=='O') q.offer(new int[]{0,i});
            if(board[m-1][i]=='O') q.offer(new int[]{m-1,i});
        }

        while(!q.isEmpty()){

            int[] cell = q.poll();
            int r = cell[0];
            int c = cell[1];
            if(r<0 || c<0 || r>=m || c>=n || board[r][c]!='O') continue;
            board[r][c]='#';
            for(int[] dir:dirs){
                q.offer(new int[]{r+dir[0],c+dir[1]});

            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='#') board[i][j]='O';
                else if(board[i][j]=='O') board[i][j]='X';
            }
        }
    }
}