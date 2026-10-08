class Solution {
    public int maxProfit(int[] prices) {
        int maxp = 0;
        int minprice = Integer.MAX_VALUE;

        for(int i:prices){
            if(i<minprice){
                minprice = i;
            }
            maxp = Math.max(maxp,i-minprice);
        }
        return maxp;
    }
}