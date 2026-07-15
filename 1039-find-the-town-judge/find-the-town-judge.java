class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] ind = new int[n+1];
        int[] od = new int[n+1];

        for(int[] i:trust){
            od[i[0]]++;
            ind[i[1]]++;
        }

        for(int i=1;i<=n;i++){
            if(ind[i]==n-1 && od[i]==0){
                return i;
            }
        }
        return -1;
    }
}