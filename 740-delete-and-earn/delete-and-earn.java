class Solution {
    public int deleteAndEarn(int[] nums) {
        int n = nums.length;
        int max=-1;
        for(int num:nums){
            max = Math.max(max,num);
        }
        int[] points = new int[max+1];
        int[] dp = new int[max+1];
        for(int i=0;i<n;i++){
            points[nums[i]]+=nums[i];
        }
        dp[0]=points[0];
        dp[1]=Math.max(points[0],points[1]);

        for(int i=2;i<=max;i++){
            dp[i] = Math.max(dp[i-1],points[i]+dp[i-2]);
        }

        return dp[max];
    }
}