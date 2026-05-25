class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r= Arrays.stream(piles).max().getAsInt();
        int ans=l;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(canEatAll(mid,piles,h)){
                ans = mid;
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return ans;
    }
    boolean canEatAll(int k,int[] piles,int h){
        long hrs = 0;
        for(int pile:piles){
            hrs += (pile+k-1)/k;
            if(hrs>h) return false;
        }
        return hrs<=h;
    }
}