class Solution {
    public List<List<Integer>> combinationSum(int[] cand, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(cand,target,res,new ArrayList<>(),0);
        return res;
    }
    private void backtrack(int[] cand,int target,List<List<Integer>> res,List<Integer> cur,int idx){
        if(target==0){
            res.add(new ArrayList<>(cur));
            return;
        }
        if(target<0) return;
        for(int i=idx;i<cand.length;i++){
            cur.add(cand[i]);
            backtrack(cand,target-cand[i],res,cur,i);
            cur.remove(cur.size()-1);
        }
    }
}