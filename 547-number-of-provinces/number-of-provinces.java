class Solution {
    int[] parent;
    int count;
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        parent  = new int[n];
        count = n;
        for(int i=1;i<n;i++){
            parent[i]=i;
        }    

        for(int i=0;i<n;i++){
            for(int j=0;j<isConnected[0].length;j++){

                if(isConnected[i][j]==1){

                    union(i,j);
                }
            }
        }
        return count;
    }
    private void union(int a,int b){
        int rootA = find(a);
        int rootB = find(b);
        
        if(rootA==rootB){
            return;
        }
        parent[rootB]=rootA;
        count--;
    }
    private int find(int x){
        if(parent[x]==x){
            return x;
        }
        return parent[x] = find(parent[x]);
    }
}