class Solution {
    int[] parent;
    public boolean equationsPossible(String[] equations) {
        parent = new int[26];

        for(int i=0;i<26;i++){
            parent[i]=i;
        }

        for(String eq:equations){
            if(eq.charAt(1)=='='){
                union(eq.charAt(0)-'a',eq.charAt(3)-'a');
            }
        }
        for(String eq:equations){
            if(eq.charAt(1)=='!'){
                if(find(eq.charAt(0)-'a')==find(eq.charAt(3)-'a')){
                    return false;
                }
            }
        }
        return true;
    }

    private void union(int a,int b){
        int rootA = find(a);
        int rootB = find(b);
    
        if(rootA==rootB){
            return ;
        }

        parent[rootB]=rootA;

    }
    private int find(int x){
        if(parent[x]==x){
            return x;
        }
        return parent[x]=find(parent[x]);
    }
    
}