class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        bc(res,new ArrayList<>(),nums,new boolean[nums.length]);
        return res;
    }
    private void bc(List<List<Integer>> res,List<Integer> cur,int[] nums,boolean[] used){
        if(cur.size()==nums.length){
            res.add(new ArrayList<>(cur));
        }

        for(int i=0;i<nums.length;i++){
            if(used[i]) continue;
            if(i>0 && nums[i]==nums[i-1] && !used[i-1]) continue;
            used[i]=true;
            cur.add(nums[i]);
            bc(res,cur,nums,used);

            cur.remove(cur.size()-1);
            used[i]=false;
        }
    }
}