class Solution {
    int[] parent;
    int[] size;
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        parent = new int[n];
        size = new int[n];
        List<int[]> edges = new ArrayList<>();
        for(int i=0;i<n;i++){
            parent[i] = i;
            size[i]=1;
        }

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int dist = Math.abs(points[i][0]-points[j][0]) + Math.abs(points[i][1]-points[j][1]);
                edges.add(new int[]{dist,i,j});
            }
        }

        edges.sort((a,b)->a[0]-b[0]);
        int cost=0,cnt=0;
        for(int[] e:edges){
            int wt = e[0],u=e[1],v=e[2];

            if(union(u,v)){
                cost+=wt;
                cnt++;
                if(cnt==n-1) break;
            }
        }
        return cost;
    }
    private boolean union(int a,int b){
        int rootA = find(a);
        int rootB = find(b);

        if(rootA==rootB){
            return false;
        }

        if(size[rootA]<size[rootB]){
            int temp = rootA;
            rootA = rootB;
            rootB = temp;
        }

        parent[rootB]=rootA;
        size[rootA]+=size[rootB];

        return true;
    }
    private int find(int x){
        if(parent[x]==x){
            return x;
        }
        return parent[x] = find(parent[x]);
    }
}