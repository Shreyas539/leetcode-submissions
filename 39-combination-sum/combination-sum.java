class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res= new ArrayList<>();

        backtrack(candidates,0,new ArrayList<>(),res,target);
        return res;
    }
    private void backtrack(int[] cand,int idx,List<Integer> cur,List<List<Integer>> res,int remain){
        if(remain==0){
            res.add(new ArrayList<>(cur));
        }
        if(remain<0)return;
        for(int i=idx;i<cand.length;i++){
            cur.add(cand[i]);
            backtrack(cand,i,cur,res,remain-cand[i]);
            cur.remove(cur.size()-1);
        }
    } 
}