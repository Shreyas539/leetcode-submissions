class Solution {
    public int findPeakElement(int[] nums) {
       int idx=0;
        int max=nums[0];
       for(int i=0;i<nums.length;i++){
        if(nums[i]>max){
            idx=i;
            max=nums[i];
        }
       } 
       return idx;
    }
}