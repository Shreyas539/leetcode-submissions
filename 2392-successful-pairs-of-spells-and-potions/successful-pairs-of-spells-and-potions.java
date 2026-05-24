class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int m = potions.length;
        Arrays.sort(potions);
        int[] res = new int[spells.length];
        int i=0;
        for(int s:spells){
            int l=0,r=potions.length-1, idx=potions.length;

            while(l<=r){
                int mid = l+(r-l)/2;
                if((long)s*potions[mid]>=success){
                    r = mid-1;
                    idx=mid;
                }else{
                    l=mid+1;
                }
            }
            res[i++] = m-idx;
        }

        return res;
    }
}