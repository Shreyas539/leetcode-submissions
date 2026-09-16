class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] used  = new boolean[nums.length];
        backtrack(nums,res,new ArrayList<>(),used);
        return res;
    }
    private void backtrack(int[] nums,List<List<Integer>> res,List<Integer> cur,boolean[] used){
        if(cur.size()==nums.length){
            res.add(new ArrayList<>(cur));
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(used[i]) continue;
            if(i>0 && nums[i]==nums[i-1] && !used[i-1]) continue;

            used[i]=true;
            cur.add(nums[i]);
            backtrack(nums,res,cur,used);
            cur.remove(cur.size()-1);
            used[i]=false;
        }
    }
}