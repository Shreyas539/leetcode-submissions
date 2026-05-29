class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        bc(0,res,nums,new ArrayList<>());
        return res;
    }
    private void bc(int start,List<List<Integer>> res,int[] nums,List<Integer> cur){
        res.add(new ArrayList<>(cur));

        for(int i=start;i<nums.length;i++){
            cur.add(nums[i]);
            bc(i+1,res,nums,cur);
            cur.remove(cur.size()-1);
        }
    }
}