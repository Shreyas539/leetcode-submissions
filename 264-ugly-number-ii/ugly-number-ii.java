class Solution {
    public int nthUglyNumber(int n) {
        int[] ugly = new int[n];

        int p2=0,p3=0,p5=0;
        ugly[0]=1;

        for(int i=1;i<n;i++){
            int nxt2 = ugly[p2]*2;
            int nxt3 = ugly[p3]*3;
            int nxt5 = ugly[p5]*5;

            int nxtugly = Math.min(nxt2,Math.min(nxt3,nxt5));

            ugly[i] = nxtugly;

            if(nxt2==nxtugly){
                p2++;
            } 

            if(nxt3==nxtugly){
                p3++;
            }

            if(nxt5==nxtugly){
                p5++;
            }
        }

        return ugly[n-1];
    }
}