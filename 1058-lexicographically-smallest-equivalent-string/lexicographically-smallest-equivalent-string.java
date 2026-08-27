class Solution {
    int[] parent;
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        parent = new int[26];

        for(int i=0;i<26;i++){
            parent[i] = i;
        }

        for(int i=0;i<s1.length();i++){
            int a = s1.charAt(i)-'a';
            int b = s2.charAt(i)-'a';

            union(a,b);
        }

        StringBuilder sb = new StringBuilder();

        for(char ch:baseStr.toCharArray()){
            int root = find(ch-'a');

            sb.append((char)(root+'a'));
        }

        return sb.toString();
    }
    private int find(int x){
        if(parent[x]==x){
            return x;
        }
        return parent[x] = find(parent[x]);
    }
    private void union(int a,int b){
        int rootA = find(a);
        int rootB = find(b);

        if(rootA==rootB){
            return;
        }

        if(rootA<rootB){
            parent[rootB] = rootA;
        }else{
            parent[rootA] = rootB;
        }
    }
}