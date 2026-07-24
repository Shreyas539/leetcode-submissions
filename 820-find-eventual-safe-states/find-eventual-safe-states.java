class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] state = new int[n]; // 0=unvisited, 1=visiting, 2=safe
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (dfs(graph, state, i)) {
                res.add(i);
            }
        }
        return res;
    }
    private boolean dfs(int[][] graph, int[] state, int node) {
        if (state[node] != 0) {
            return state[node] == 2; // safe if already proven safe
        }

        state[node] = 1; // mark visiting
        for (int nei : graph[node]) {
            if (!dfs(graph, state, nei)) {
                return false; // found cycle
            }
        }
        state[node] = 2; // mark safe
        return true;
    }
}