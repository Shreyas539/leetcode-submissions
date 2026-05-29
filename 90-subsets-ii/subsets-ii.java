class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        bc(0,res,nums,new ArrayList<>());
        return res;
    }
    private void bc(int start,List<List<Integer>> res,int[] nums,List<Integer> cur){
        res.add(new ArrayList<>(cur));

        for(int i=start;i<nums.length;i++){
            if(i>start && nums[i]==nums[i-1]) continue;
            cur.add(nums[i]);
            bc(i+1,res,nums,cur);
            cur.remove(cur.size()-1);
        }
    }
}