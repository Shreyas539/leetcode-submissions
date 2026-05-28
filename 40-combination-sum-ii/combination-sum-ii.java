class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates,target,res,new ArrayList<>(),0);
        return res;
    }
    private void backtrack(int[] cand,int remain,List<List<Integer>> res,List<Integer> cur,int idx){
        if(remain==0){
            res.add(new ArrayList<>(cur));
            return;
        }
        if(remain<0)return;

        for(int i=idx;i<cand.length;i++){
            if(i>idx && cand[i]==cand[i-1])  continue;
            cur.add(cand[i]);
            backtrack(cand,remain-cand[i],res,cur,i+1);
            cur.remove(cur.size()-1);
        }
    }
}