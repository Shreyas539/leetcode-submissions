class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums,res,new ArrayList<>(),0);
        return res;
    }
    private void backtrack(int[] nums,List<List<Integer>> res,List<Integer> cur,int idx){
        
            res.add(new ArrayList<>(cur));
        

        for(int i=idx;i<nums.length;i++){
            if(i>idx && nums[i]==nums[i-1]){
                continue;
            }
            cur.add(nums[i]);
            backtrack(nums,res,cur,i+1);
            cur.remove(cur.size()-1);
        }
    }
}