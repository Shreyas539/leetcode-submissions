class Solution {
    int[] parent;
    
    public int makeConnected(int n, int[][] connections) {
        parent = new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
        if(connections.length<n-1) return -1;
        int comp=n;
        for(int i=0;i<connections.length;i++){
            int u = connections[i][0];
            int v = connections[i][1];

            if(union(u,v)){
                comp--;
            }
        }    
        return comp-1;
    }

    private boolean union(int a,int b){
        int rootA = find(a);
        int rootB = find(b);

        if(rootA==rootB){
            return false;
        }

        parent[rootB]=rootA;
        return true;
    }
    private int find(int x){
        if(parent[x]==x){
            return x;
        }
        return parent[x]=find(parent[x]);
    }
}