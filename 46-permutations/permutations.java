class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(nums,res,new ArrayList<>(),0,used);
        return res;
    }
    private void backtrack(int[] nums,List<List<Integer>> res,List<Integer> cur,int idx,boolean[] used){
        if(cur.size()==nums.length){
            res.add(new ArrayList<>(cur));
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(used[i]) continue;
            used[i]=true;
            cur.add(nums[i]);
            backtrack(nums,res,cur,idx+1,used);
            cur.remove(cur.size()-1);
            used[i]=false;
        }

    }
}