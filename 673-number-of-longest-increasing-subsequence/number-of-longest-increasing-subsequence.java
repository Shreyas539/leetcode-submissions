class Solution {
    public int findNumberOfLIS(int[] nums) {
        int maxlen = 1;
        int n = nums.length;
        int[] dp = new int[n];
        int[] count = new int[n];
        Arrays.fill(dp,1);
        Arrays.fill(count,1);

        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    if(1+dp[j]>dp[i]){
                        dp[i]= 1+dp[j];
                        count[i] = count[j];
                    }else if(1+dp[j]==dp[i]){
                        count[i]+=count[j];
                    }
                    
                }
            }
            maxlen = Math.max(maxlen,dp[i]);
        }
        int ans=0;
        for(int i=0;i<n;i++){
            if(dp[i]==maxlen){
                ans+=count[i];
            }
        }
        return ans;


    }
}