class Solution {
    public boolean isPowerOfTwo(int n) {
        long mask = 1;
        while(mask<=n){
            if(mask==n) return true;
            mask = mask<<1;
        }
        return false;
    }
}