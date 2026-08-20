class Solution {
    int[] parent;
    int[] size;
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        parent  = new int[n+1];
        size= new int[n+1];

        for(int i=1;i<=n;i++){
            parent[i]=i;
            size[i]=1;
        }

        for(int[] edge:edges){
            if(union(edge[0],edge[1])){
                return new int[]{edge[0],edge[1]};
            }
        }
        return new int[]{};
    }
    private boolean union(int a,int b){
        int rootA = find(a);
        int rootB = find(b);

        if(rootA==rootB) return true;

        if(size[rootA]<size[rootB]){
            int temp= rootA;
            rootA = rootB;
            rootB = temp;
        }
        parent[rootB] = rootA;
        size[rootA]+=size[rootB];
        return false;
    }
    private int find(int x){
        if(parent[x]==x){
            return x;
        }
        return parent[x] = find(parent[x]);
    }
}