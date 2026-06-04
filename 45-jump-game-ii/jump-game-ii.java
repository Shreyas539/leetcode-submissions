class Solution {
    public int jump(int[] nums) {
        int farthest = 0;
        int curend=0;
        int steps = 0;
        for(int i=0;i<nums.length-1;i++){
            farthest = Math.max(farthest,i+nums[i]);
            if(i==curend){
                steps++;
                curend=farthest;
            }
        }
        return steps;
    }
}