class Solution {
    int[] parent;
    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        parent = new int[n];
        for(int i=0;i<n;i++){
            parent[i] = i;
        }
        int count=n;

        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                if(similar(strs[i],strs[j])){
                    if(union(i,j)){
                        count--;
                    }
                }
            }
        }
        return count;
    }
    private boolean union(int a,int b){
        int rootA = find(a);
        int rootB = find(b);

        if(rootA==rootB){
            return false;
        }

        parent[rootB] = rootA;
        return true;
    }
    private int find(int x){
        if(parent[x]==x){
            return x;
        }
        return parent[x] = find(parent[x]);
    }
    private boolean similar(String a,String b){
        int diff=0;
        for(int i=0;i<a.length();i++){
            if(a.charAt(i)!=b.charAt(i)){
                diff++;
            }
        }

        return diff==0 || diff ==2 || diff==1;
    }
}