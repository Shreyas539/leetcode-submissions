class Solution {
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    public int shortestBridge(int[][] grid) {
         int n = grid.length;
        Queue<int[]> q = new LinkedList<>();
        boolean found = false;
        
        // Step 1: find and mark the first island
        for (int i = 0; i < n; i++) {
            if (found) break;
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j, q);
                    found = true;
                    break;
                }
            }
        }

        // Step 2: BFS expansion
        int steps = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int k = 0; k < size; k++) {
                int[] cur = q.poll();
                for (int[] d : dirs) {
                    int ni = cur[0] + d[0];
                    int nj = cur[1] + d[1];
                    if (ni < 0 || nj < 0 || ni >= n || nj >= n) continue;
                    if (grid[ni][nj] == 1) return steps; // reached second island
                    if (grid[ni][nj] == 0) {
                        grid[ni][nj] = 2;
                        q.offer(new int[]{ni,nj});
                    }
                }
            }
            steps++;
        }
        return -1;
    }
    private void dfs(int[][] grid, int i, int j, Queue<int[]> q) {
        int n = grid.length;
        if (i < 0 || j < 0 || i >= n || j >= n || grid[i][j] != 1) return;
        grid[i][j] = 2;
        q.offer(new int[]{i,j});
        for (int[] d : dirs) {
            dfs(grid, i+d[0], j+d[1], q);
        }
    }
}