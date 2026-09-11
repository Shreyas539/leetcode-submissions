class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums,res,new ArrayList<>(),0);
        return res;
    }
    private void backtrack(int[] nums,List<List<Integer>> res,List<Integer> cur,int idx){
        res.add(new ArrayList<>(cur));

        for(int i=idx;i<nums.length;i++){
            cur.add(nums[i]);
            backtrack(nums,res,cur,i+1);
            cur.remove(cur.size()-1);
        }
    }
    
}